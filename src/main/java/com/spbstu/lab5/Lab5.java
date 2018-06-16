package com.spbstu.lab5;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.$;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
@JPage(url = "/index.htm", title = "Index Page")
public class Lab5 extends WebSite {
    //из 2 лабы
    //  private  WebDriver driver;

    @FindBy(css = ".dropdown-toggle[href='#']")
    private static SelenideElement LoginMenu;
    @FindBy(css = "#Login")
    private static SelenideElement LoginInput;
    @FindBy(css = "#Password")
    private static SelenideElement PasswordInput;
    @FindBy(css = "button[type='submit']")
    private static Button SubmitButton;
    @FindBy(xpath = "//div[@class='profile-photo']//span")
    private static SelenideElement UserName;

    public Lab5() {
        Selenide.page(this);
    }

    public void Open(String site) {
        Selenide.open(site);
    }

    public static void CheckLogin(String login, String password, String user) {//идентификация
        LoginMenu.click();
        LoginInput.setValue(login);
        PasswordInput.setValue(password);
        SubmitButton.click();
        UserName.shouldBe(visible);
        UserName.shouldHave(text(user));
    }





    //5 lab /2
    @FindBy(css = ".dropdown-toggle[href='page2.htm']")
    private static SelenideElement MetalsColorsHeader;//верхнее меню - Metals & Colors

    public static void ServiceHeader(){
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



}
