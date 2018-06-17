package com.spbstu.lab5.Login;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/index.htm", title = "Index Page")
public class TestPage extends WebPage {
    private LogForm LoginForm;
    @FindBy(css = ".uui-profile-menu")
    private Label Menu;
    @FindBy(css = ".uui-navigation a[href='page2.htm']")
    private Button MetColPageButton;

    public void Login(User user) {
        Menu.click();
        LoginForm.loginAs(user);
    }

    public void OpenMetalsAndColorsPage() {
        MetColPageButton.click();
    }
}
