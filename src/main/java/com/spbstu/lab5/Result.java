package com.spbstu.lab5;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.web.matcher.junit.Assert;
import com.spbstu.lab5.DataProv.DataForResult;
import org.openqa.selenium.support.FindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;


public class Result extends WebPage {
    @FindBy(css = ".radio")
    public RadioButtons Radios;

    @JFindBy(css = "#elements-checklist | .checkbox label")
    public CheckList Elements;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    public Dropdown Color;

    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"))
    public final ThreadLocal<ComboBox> Metal = new ThreadLocal<>();

    @JComboBox(root = @FindBy(css = ".salad"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button"))
    public ComboBox Vegetables;

    @FindBy(css = ".panel-body-list.results li")
    public TextList ResultInLog;

    public TextList ExpectedResult;

    @FindBy(css = "#submit-button")
    public Button Submit;

    public void UnSelectElementsAndVegetables(DataForResult MetalsColors) {
        for (int i = 0; i < MetalsColors.GetElements().length; i++)
            Elements.select(MetalsColors.GetElements()[i]);
        for (int i = 0; i < MetalsColors.GetVegetables().length; i++)
            Vegetables.select(MetalsColors.GetVegetables()[i]);
    }

    public void SelectMetalsColors(DataForResult MetalsColors) {
        Radios.select(Integer.toString(MetalsColors.GetSummary()[0]));
        Radios.select(Integer.toString(MetalsColors.GetSummary()[1]));
        for (int i = 0; i < MetalsColors.GetElements().length; i++)
            Elements.select(MetalsColors.GetElements()[i]);
        Color.select(MetalsColors.GetColor());
        Metal.get().select(MetalsColors.GetMetal());
        for (int i = 0; i < MetalsColors.GetVegetables().length; i++)
            Vegetables.select(MetalsColors.GetVegetables()[i]);
        Submit.click();
        UnSelectElementsAndVegetables(MetalsColors);
    }

    public void CheckSelectedMetalsColors(DataForResult MetalsColors) {
        int sum = (MetalsColors.GetSummary()[0]+MetalsColors.GetSummary()[1]);
        Assert.assertTrue(ResultInLog.getValue().contains(Integer.toString(sum)));
        for(int i=0; i<MetalsColors.GetElements().length; i++)
            Assert.assertTrue(ResultInLog.getValue().contains(MetalsColors.GetElements()[i]));
        Assert.assertTrue(ResultInLog.getValue().contains(MetalsColors.GetColor()));
        Assert.assertTrue(ResultInLog.getValue().contains(MetalsColors.GetMetal()));
        for(int i=0; i<MetalsColors.GetVegetables().length; i++)
            Assert.assertTrue(ResultInLog.getValue().contains(MetalsColors.GetVegetables()[i]));
    }

}
