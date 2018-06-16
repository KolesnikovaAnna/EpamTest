package com.spbstu.lab4;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class Lab4 {
    //из 2 лабы
    //  private  WebDriver driver;

    @FindBy(css = ".dropdown-toggle[href='#']")
    private SelenideElement LoginMenu;
    @FindBy(css = "#Login")
    private SelenideElement LoginInput;
    @FindBy(css = "#Password")
    private SelenideElement PasswordInput;
    @FindBy(css = "button[type='submit']")
    private SelenideElement SubmitButton;
    @FindBy(xpath = "//div[@class='profile-photo']//span")
    private SelenideElement UserName;
    @FindBy(css = ".benefit-icon")
    private ElementsCollection Pictures;
    @FindBy(css = ".benefit-txt")
    private ElementsCollection PicTexts;
    @FindBy(css = ".main-txt")
    private SelenideElement MainText;
    @FindBy(css = ".main-txt")
    private SelenideElement HomePage;

    public Lab4() {
        Selenide.page(this);
    }

    public void Open(String site) {
        Selenide.open(site);
        Selenide.zoom(0.5);
    }

    public void Close(){
        Selenide.close();
    }

    public void CheckLogin(String login, String password, String user) {//идентификация
        LoginMenu.click();
        LoginInput.setValue(login);
        PasswordInput.setValue(password);
        SubmitButton.click();
        UserName.shouldBe(visible);
        UserName.shouldHave(text(user));
    }

    public void CheckMainText(String str) {
        MainText.shouldHave(text(str));
    }

    public void CheckPictureTexts(String[] texts) {
        PicTexts.shouldHaveSize(texts.length);
        for (int i = 0; i < texts.length; i++) {
            PicTexts.get(i).shouldBe(visible);
            PicTexts.get(i).shouldHave(text(texts[i]));
        }
    }

    public void CheckPicturesCount(int n) {
        Pictures.shouldHaveSize(n);
        for (SelenideElement picture : Pictures)
            picture.shouldBe(visible);
    }



    //3 lab case1
    @FindBy(css = ".dropdown-toggle[href='page1.htm']")
    private SelenideElement ServiceHeader;//верхнее меню - сервис - саппорт
    @FindBy(css = ".dropdown-menu > li > a[href='page3.htm']") //ребенок
    private SelenideElement SupportHeader;
    @FindBy(css = ".sub-menu a[href='page1.htm']")
    private SelenideElement ServiceLeft;
    @FindBy(css = ".sub > li > a[href='page5.htm']") //левое меню - сервис - ComplexTable
    private SelenideElement ComplexTable;
    @FindBy(css = "li a[href='page8.htm']")
    private SelenideElement DELeft;//переход на DEP
    @FindBy(css = ".dropdown-menu > li > a[href='page4.htm']") //верхнее меню - сервис - Dates
    private SelenideElement Dates;
    @FindBy(css = "li a[href='index.htm']")
    private SelenideElement Home;//переход исходную страницу

    public void GoHome(){
        Home.click();
    }

    public void ServiceHeader(){
        LoginMenu.click();
        ServiceHeader.click();
        SupportHeader.click();
    }

    public void ServiceLeft(){
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
