package com.spbstu.lab4;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;

public class DEP {
    @FindBy(css = ".label-checkbox")
    private ElementsCollection Checkboxes;
    @FindBy(css = ".label-radio")
    private ElementsCollection Radios;
    @FindBy(css = "button[name='Default Button']")
    private SelenideElement DefaultButton;
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

    public DEP() {
        Selenide.page(this);
        Selenide.zoom(0.5);
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
        DefaultButton.shouldBe(visible);
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
}
