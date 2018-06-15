package com.spbstu.lab5;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.$;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;

public class Lab5 extends WebSite {
    //из 2 лабы
    //  private  WebDriver driver;

    @FindBy(css = ".dropdown-toggle[href='#']")
    private SelenideElement LoginMenu;
    @FindBy(css = "#Login")
    private SelenideElement LoginInput;
    @FindBy(css = "#Password")
    private SelenideElement PasswordInput;
    @FindBy(css = "button[type='submit']")
    private Button SubmitButton;
    @FindBy(xpath = "//div[@class='profile-photo']//span")
    private SelenideElement UserName;

    public Lab5() {
        Selenide.page(this);
    }

    public void Open(String site) {
        Selenide.open(site);
    }

    public void CheckLogin(String login, String password, String user) {//идентификация
        LoginMenu.click();
        LoginInput.setValue(login);
        PasswordInput.setValue(password);
        SubmitButton.click();
        UserName.shouldBe(visible);
        UserName.shouldHave(text(user));
    }




    //5 lab /2
    @FindBy(css = ".dropdown-toggle[href='page2.htm']")
    private SelenideElement MetalsColorsHeader;//верхнее меню - Metals & Colors

    public void ServiceHeader(){
        LoginMenu.click();
        MetalsColorsHeader.click();
    }

/*    public void ServiceLeft(){
        LoginMenu.click();
        ComplexTable.click();
    }

    public void GoToDates(){
        ServiceHeader.click();
        Dates.click();
    }

    public void GoToDifferentElements() {//change
        if (ServiceHeader.isDisplayed())
            ServiceHeader.click();
        DELeft.click();
    }
*/


    //case 2
    @FindBy(xpath = "(//div[@jdi-type='IRange']/a[@href='#'])[1]")
    public SelenideElement LeftSlider;
    @FindBy(xpath = "(//div[@jdi-type='IRange']/a[@href='#'])[2]")
    public SelenideElement RightSlider;
    @FindBy(css = ".ui-slider")
    private SelenideElement SliderTrack;


    public static double GetStep(SelenideElement element) {
        double step = element.getSize().width / 100.0;
        return step;
    }

    public static int GetCurrentPosition(SelenideElement sliderHandle) {
        return Integer.parseInt(sliderHandle.getText());
    }
    public static int getOffset(int position, SelenideElement sliderTrack, SelenideElement sliderHandle) {
        int offset = (int) Math.round((position - GetCurrentPosition(sliderHandle)) * GetStep(sliderTrack));
        return offset - 2;
    }

    public void MoveSliders(int left, int right) {
        if (left > Integer.parseInt($(".ui-slider-handle:nth-of-type(2)>span").getText())) {

            actions().dragAndDropBy(RightSlider, getOffset(right, SliderTrack, RightSlider), 0).perform();
            actions().dragAndDropBy(LeftSlider, getOffset(left, SliderTrack, LeftSlider), 0).perform();
        } else {

            actions().dragAndDropBy(LeftSlider, getOffset(left, SliderTrack, LeftSlider), 0).perform();
            actions().dragAndDropBy(RightSlider, getOffset(right, SliderTrack, RightSlider), 0).perform();
        }
    }
}
