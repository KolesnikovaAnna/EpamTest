package com.spbstu.lab2;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class TestLab2 extends Init2{

    @Test
    public void Lab2Test() {
        TestPage.Open(Data.Site);
        Assert.assertEquals(TestPage.GetSite(), Data.Site);
        Assert.assertEquals(TestPage.GetTitle(), Data.Title);
        TestPage.Login(Data.Login, Data.Password);//ввод логина. пароля
        Assert.assertEquals(TestPage.GetUserName(), Data.UserName);
        Assert.assertEquals(TestPage.GetPictureNumber(), 4);
        ArrayList<String> texts = TestPage.GetPictureTexts();
        for (int i = 0; i < texts.size(); i++)
            Assert.assertEquals(texts.get(i), Data.Texts[i]);
        Assert.assertEquals(TestPage.GetMainHeader(), Data.MainHeader);
        Assert.assertEquals(TestPage.GetMainText(), Data.HomePage);
    }
}
