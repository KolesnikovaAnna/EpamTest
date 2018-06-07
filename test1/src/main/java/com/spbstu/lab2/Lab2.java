package com.spbstu.lab2;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class Lab2 {

    private final WebDriver driver;

    @FindBy(css = ".dropdown-toggle[href='#']")
    private WebElement LoginMenu;
    @FindBy(css = "#Login")
    private WebElement LoginInput;
    @FindBy(css = "#Password")
    private WebElement PasswordInput;
    @FindBy(css = "button[type='submit']")
    private WebElement SubmitButton;
    @FindBy(xpath = "//div[@class='profile-photo']//span")
    private WebElement UserName;
    @FindBy(css = ".benefit-icon")
    private List<WebElement> Pictures;
    @FindBy(css = ".benefit-txt")
    private List<WebElement> Texts;
    @FindBy(css = ".main-title")
    private WebElement MainHeader;
    @FindBy(css = ".main-txt")
    private WebElement HomePage;

    public Lab2(WebDriver driver) {
        this.driver = driver;
    }

    public void Open(String Site) {
        driver.navigate().to(Site);
    }

    public String GetSite() {
        return driver.getCurrentUrl();
    }

    public String GetTitle() {
        return driver.getTitle();
    }

    public String GetUserName() {
        return UserName.getText();
    }

    public String GetMainHeader() {
        return MainHeader.getText();
    }

    public String GetMainText() {
        return HomePage.getText();
    }

        public int GetPictureNumber() {
        return Pictures.size();
    }

    public void Login(String login, String password) {//идентификация
        LoginMenu.click();
        LoginInput.sendKeys(login);
        PasswordInput.sendKeys(password);
        SubmitButton.click();
    }

    public ArrayList<String> GetPictureTexts() {
        ArrayList<String> array = new ArrayList<>();
        for (WebElement pictureText : Texts)
            array.add(pictureText.getText());
        return array;
    }
}
