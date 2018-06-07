package com.spbstu.lab1;
import java.util.ArrayList;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestLab1 extends Init1 {

    @Test
    public void Lab1() {
        String Site = "https://jdi-framework.github.io/tests/index.htm";
        driver.get("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals(driver.getCurrentUrl(), Site);//проверка сайта
        String Title = "Index Page";
        Assert.assertEquals(driver.getTitle(), Title);//проверка заголовка

        String Login = "epam";
        String Password = "1234";
        String UserName = "PITER CHAILOVSKII";

       // driver.get("https://jdi-framework.github.io/tests/index.htm");
        driver.findElement(By.cssSelector("[href='#']")).click();
        driver.findElement(By.cssSelector("#Login")).sendKeys(Login);
        driver.findElement(By.cssSelector("#Password")).sendKeys(Password);
        driver.findElement(By.cssSelector("[type = 'submit']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("[href = '#']")).isDisplayed());//проверка видимости, имени, заголовка, количества изображений
        Assert.assertEquals(driver.findElement(By.cssSelector("[href='#']")).getText(), UserName);
        Assert.assertEquals(driver.getTitle(), Title);
        Assert.assertEquals((driver.findElements(By.cssSelector("[class = 'benefit-icon']")).size()), 4);

        ArrayList<String> Texts = new ArrayList<String>();//проверка тектов
        Texts.add("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM projec");
        Texts.add("To be flexible and\n" +
                "customizable");
        Texts.add("To be multiplatform");
        Texts.add("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
        Assert.assertEquals((driver.findElements(By.cssSelector("[class = 'benefit-txt']")).size()), 4);

        ArrayList<WebElement> TextsUnderIcons;//текст под иконками
        TextsUnderIcons = (ArrayList<WebElement>) driver.findElements(By.cssSelector("[class = 'benefit-txt']")); // проверка текста под иконками
        for (int i = 0; i < Texts.size(); i++) {
            Assert.assertEquals(TextsUnderIcons.get(i).getText(), Texts.get(i));
        }
        String MainHeader = "EPAM FRAMEWORK WISHES…";
        String HomePage = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        Assert.assertEquals((driver.findElement(By.cssSelector(".main-title"))).getText(), MainHeader);//проверка совпадения текствов
        Assert.assertEquals((driver.findElement(By.cssSelector(".main-txt"))).getText(), HomePage);
    }
}

