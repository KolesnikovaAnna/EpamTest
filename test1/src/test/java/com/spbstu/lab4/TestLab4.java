package com.spbstu.lab4;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Listeners(Allure.class)
@Features({"Testing"})
@Stories({"the test"})
public class TestLab4 {
    private static Lab4 TestPage;
    private static DEP DEPage;

    @BeforeClass(description = "Set browser and initialize pages")
    public void beforeSuite() {
        Configuration.browser = "chrome";
        TestPage = new Lab4();
        DEPage = new DEP();
    }

    @Test(description = "Test home page and elements")
    public void Task1() {
        TestPage.Open(Data.Site);
        TestPage.CheckLogin( Data.Login, Data.Password, Data.UserName);
        TestPage.CheckPicturesCount(Data.PicNum);
        TestPage.CheckPictureTexts(Data.Texts);
        TestPage.CheckMainText(Data.HomePage);
        TestPage.GoToDifferentElements();

        DEPage.CheckAllElements(DataForDEP.CheckboxNum,DataForDEP.RadioNum);
        DEPage.SelectCheckbox(DataForDEP.CHECKBOX1.Str);
        DEPage.SelectCheckbox(DataForDEP.CHECKBOX3.Str);
        DEPage.SelectRadio(DataForDEP.RADIO4.Str);
        DEPage.SelectDropdown(DataForDEP.DROPDOWN4.Str);
        DEPage.CheckCheckboxInLog(DataForDEP.CHECKBOX1.Str, "true");
        DEPage.CheckCheckboxInLog(DataForDEP.CHECKBOX3.Str, "true");
        DEPage.CheckRadioInLog(DataForDEP.RADIO4.Str);
        DEPage.CheckDropdownColorInLog(DataForDEP.DROPDOWN4.Str);
        DEPage.UnselectCheckbox(DataForDEP.CHECKBOX1.Str);
        DEPage.UnselectCheckbox(DataForDEP.CHECKBOX3.Str);
        DEPage.CheckCheckboxInLog(DataForDEP.CHECKBOX1.Str, "false");
        DEPage.CheckCheckboxInLog(DataForDEP.CHECKBOX3.Str, "false");
    }
}
