package com.spbstu.lab5;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.web.matcher.testng.Assert;
import com.spbstu.lab5.DataProv.DataForResult;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page2.htm", title = "Metal and Colors")
public class MetalsColors extends WebPage {
    @JComboBox(root = @FindBy(css = "#salad-dropdown"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "button"))
    public static ComboBox Components;

    @FindBy(css = ".radio")
    static private RadioButtons Radios;

    @JFindBy(css = "#elements-checklist .checkbox label")
    static private CheckList Elements;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    static private Dropdown Color;

    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "input[type='text']"))
    static private ComboBox Metal;

    @FindBy(css = ".panel-body-list.results li")
    static private TextList ResultInLog;

    @FindBy(css = "#submit-button")
    static private Button submit;

    public static void SetValues(DataForResult data) {
        Radios.select(String.valueOf(data.GetSummary()[0]));//Установка значений двух цифр
        Radios.select(String.valueOf(data.GetSummary()[1]));
        Elements.select(data.GetElements());//Выбор стихий
        Color.select(data.GetColor());// цвета
        Metal.select(data.GetMetal());//металлов
        for (String component : data.GetVegetables()) //овощей
            Components.select(component);
        submit.click();//Подтверждение
    }

    public static void CheckValues(DataForResult data) {
        StringBuilder value = new StringBuilder("Summary: " + String.valueOf(data.GetSummary()[0] + data.GetSummary()[1])); //Проверка суммы
        Assert.assertContains(ResultInLog.getValue(), value.toString());

        value = new StringBuilder("Elements: ");//Проверка стихий
        for (String element : data.GetElements())
            value.append(element).append(", ");
        value = new StringBuilder(value.substring(0, value.length() - 2));
        Assert.assertContains(ResultInLog.getValue(), value.toString());

        value = new StringBuilder("Color: " + data.GetColor());//цвета
        Assert.assertContains(ResultInLog.getValue(), value.toString());

        value = new StringBuilder("Metal: " + data.GetMetal());//металла
        Assert.assertContains(ResultInLog.getValue(), value.toString());

        value = new StringBuilder("Vegetables: ");//овощей
        for (String component : data.GetVegetables())
            value.append(component).append(", ");
        value = new StringBuilder(value.substring(0, value.length() - 2));
        Assert.assertContains(ResultInLog.getValue(), value.toString());
    }

    public static void UnsetValues(DataForResult data) {//Убрать все галочки
        for (String component : data.GetVegetables())
            Components.select(component);
        Elements.select(data.GetElements());
    }
}

/*
public class MetalsColors {
    @FindBy(css = ".label-checkbox")
    private ElementsCollection Checkboxes;
    @FindBy(css = ".label-radio")
    private ElementsCollection Radios;
    @FindBy(css = "button[name='calculate-button']")
    private SelenideElement CalculateButton;
    @FindBy(css = "input[value='Button']")
    private SelenideElement InputButton;
    @FindBy(css = "#mCSB_1")
    private SelenideElement LeftSection;
    @FindBy(css = "#mCSB_2")
    private SelenideElement RightSection;
    @FindBy(css = "div.colors select")
    private SelenideElement Colors;
    @FindBy(css = "ul.panel-body-list.logs")
    private SelenideElement Logs;

    public MetalsColors() {
        Selenide.page(this);
    }

    public void CheckAllElements(int n, int k) {//int num checkbox, num radio
        LeftSection.shouldBe(visible);
        RightSection.shouldBe(visible);
        for (SelenideElement checkbox : Checkboxes) {
            checkbox.shouldBe(visible);
        }
        Checkboxes.shouldHaveSize(n);
        for (SelenideElement radio : Radios){
            radio.shouldBe(visible);
        }
        Radios.shouldHaveSize(k);
        Colors.shouldBe(visible);
        InputButton.shouldBe(visible);
      //  DefaultButton.shouldBe(visible);
    }

    public void SelectCheckbox(String str) { // отметить в заданных полях
        Checkboxes.find(text(str)).$("[type=checkbox]").setSelected(true);
        Checkboxes.find(text(str)).$("[type=checkbox]").shouldBe(checked);
    }

    public void SelectRadio(String str) {
        Radios.find(text(str)).$("[type=radio]").setSelected(true);
        Radios.find(text(str)).$("[type=radio]").shouldBe(selected);
    }

    public void UnselectCheckbox(String str) {//убрать галочку
        Checkboxes.find(text(str)).$("[type=checkbox]").setSelected(false);
        Checkboxes.find(text(str)).$("[type=checkbox]").shouldNotBe(checked);
    }

    public void SelectDropdown(String color) {
        Colors.selectOption(color);
    }

    public void CheckCheckboxInLog(String str1, String str2) {
        Logs.shouldHave(text(String.format("%s: condition changed to %s", str1, str2)));
    }

    public void CheckUnselectCheckboxInLog(String str1, String str2) {
        Logs.shouldNotHave(text(String.format("%s: condition changed to %s", str1, str2)));
    }

    public void CheckRadioInLog(String str) {
        Logs.shouldHave(text(String.format("metal: value changed to %s", str)));
    }

    public void CheckUnselectRadioInLog(String str) {
        Logs.shouldNotHave(text(String.format("metal: value changed to %s", str)));
    }

    public void CheckDropdownColorInLog(String str) {
        Logs.shouldHave(text(String.format("Colors: value changed to %s", str)));
    }
}*/
