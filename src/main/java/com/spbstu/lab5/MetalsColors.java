package com.spbstu.lab5;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.web.matcher.testng.Assert;
import com.spbstu.lab5.DataProv.DataForResult;
import org.openqa.selenium.support.FindBy;


@JPage(url = "/page2.htm", title = "Metal and Colors")
public class MetalsColors extends WebPage{
    @JComboBox(root = @FindBy(css = "#salad-dropdown"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "button"))
    public ComboBox components;

    @FindBy(css = ".radio")
    private RadioButtons radios;

    @JFindBy(css = "#elements-checklist .checkbox label")
    private CheckList elements;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    private Dropdown colors;

    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "input[type='text']"))
    private ComboBox metals;

    @FindBy(css = ".panel-body-list.results li")
    private TextList resultLog;

    @FindBy(css = "#submit-button")
    private Button submit;

    public  void SetValues(DataForResult data) {
        radios.select(String.valueOf(data.GetSummary()[0]));//Установка значений двух цифр
        radios.select(String.valueOf(data.GetSummary()[1]));
        elements.select(data.GetElements());//Выбор стихий
        colors.select(data.GetColor());// цвета
        metals.select(data.GetMetal());//металлов
        for (String component : data.GetVegetables()) //овощей
            components.select(component);
        submit.click();//Подтверждение
    }

    public void CheckValues(DataForResult data) {
        StringBuilder value = new StringBuilder("Summary: " + String.valueOf(data.GetSummary()[0] + data.GetSummary()[1])); //Проверка суммы
        Assert.assertContains(resultLog.getValue(), value.toString());

        value = new StringBuilder("Elements: ");//Проверка погоды
        for (String element : data.GetElements()) value.append(element).append(", ");
        value = new StringBuilder(value.substring(0, value.length() - 2));
        Assert.assertContains(resultLog.getValue(), value.toString());

        value = new StringBuilder("Color: " + data.GetColor());//цвета
        Assert.assertContains(resultLog.getValue(), value.toString());

        value = new StringBuilder("Metal: " + data.GetMetal());//металла
        Assert.assertContains(resultLog.getValue(), value.toString());

        value = new StringBuilder("Vegetables: ");//овощей
        for (String component : data.GetVegetables()) value.append(component).append(", ");
        value = new StringBuilder(value.substring(0, value.length() - 2));
        Assert.assertContains(resultLog.getValue(), value.toString());
    }

    public  void UnsetValues(DataForResult data) {//Убрать все галочки
        for (String component : data.GetVegetables())
            components.select(component);
        elements.select(data.GetElements());
    }
}