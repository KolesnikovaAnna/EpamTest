package com.spbstu.lab3;
import org.testng.annotations.Test;



public class TestLab3 extends Init3{

    @Test
    public void Lab3Test1() {

        //case_1
        TestPage.Open(Data.Site);
        TestPage.CheckLogin(Data.Login, Data.Password, Data.UserName);
        TestPage.CheckMainText(Data.HomePage);
        TestPage.CheckPicturesCount(Data.PicNum);
        TestPage.CheckPictureTexts(Data.Texts);
        TestPage.ServiceHeader();//меню сврху support
        TestPage.ServiceLeft();//меню слева ComplexTable

        TestPage.GoToDifferentElements();
        DEPage.CheckAllElements(DataForDEP.CheckboxNum, DataForDEP.RadioNum); //num checkbox, num radio
        DEPage.SelectCheckbox(DataForDEP.CHECKBOX1.Str); DEPage.SelectCheckbox(DataForDEP.CHECKBOX3.Str);//Water,Wind
        DEPage.SelectRadio(DataForDEP.RADIO4.Str);//Selen
        DEPage.SelectDropdown(DataForDEP.DROPDOWN4.Str);//Yellow

        DEPage.CheckCheckboxInLog(DataForDEP.CHECKBOX1.Str, "true");//должны быть отмечены Water, Wind, Selen, Yellow
        DEPage.CheckCheckboxInLog(DataForDEP.CHECKBOX3.Str, "true");
        DEPage.CheckUnselectCheckboxInLog(DataForDEP.CHECKBOX2.Str, "true");//проверка, чтобы не было true
        DEPage.CheckUnselectCheckboxInLog(DataForDEP.CHECKBOX4.Str, "true");
        DEPage.CheckRadioInLog(DataForDEP.RADIO4.Str);
        DEPage.CheckUnselectRadioInLog(DataForDEP.RADIO1.Str); DEPage.CheckUnselectRadioInLog(DataForDEP.RADIO2.Str);DEPage.CheckUnselectRadioInLog(DataForDEP.RADIO3.Str);//////!!!!!!
        DEPage.CheckDropdownColorInLog(DataForDEP.DROPDOWN4.Str);

        DEPage.UnselectCheckbox(DataForDEP.CHECKBOX1.Str); DEPage.UnselectCheckbox(DataForDEP.CHECKBOX3.Str);//какие ометили в начале, их же и убрали
        DEPage.CheckCheckboxInLog(DataForDEP.CHECKBOX1.Str, "false");
        DEPage.CheckCheckboxInLog(DataForDEP.CHECKBOX3.Str, "false");
     //  TestPage.Close();
    }

    @Test
    public void Lab3Test2() {

      //    TestPage.Open(Data.Site);
        TestPage.GoHome();
        TestPage.GoToDates();
        TestPage.MoveSliders(0, 100);
        TestPage.MoveSliders(0, 0);
        TestPage.MoveSliders(100, 100);
        TestPage.MoveSliders(30, 70);
    }
}
