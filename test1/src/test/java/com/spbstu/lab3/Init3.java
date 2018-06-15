package com.spbstu.lab3;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.PageFactory;

public class Init3 {

   // private static WebDriver driver;
    public static Lab3 TestPage;
    public static DEP DEPage;

  /*  public static void init(WebDriver driver) {
           TestPage = PageFactory.initElements(driver, DEP.class);
    }*/

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
        TestPage = new Lab3();
        DEPage = new DEP();
       // datesPage = new DatesPage();
    }

    @AfterClass
    public void afterClass() {
        Selenide.close();
    }
}
