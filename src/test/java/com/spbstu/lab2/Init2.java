package com.spbstu.lab2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.PageFactory;

public class Init2 {

    private static WebDriver driver;
    public static Lab2 TestPage;
    public static void init(WebDriver driver) {
        TestPage = PageFactory.initElements(driver, Lab2.class);
    }

    @BeforeClass
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        init(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
