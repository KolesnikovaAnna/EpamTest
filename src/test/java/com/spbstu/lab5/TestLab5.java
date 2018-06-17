package com.spbstu.lab5;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.spbstu.lab5.Login.User;
import com.spbstu.lab5.DataProv.DataForResult;
import com.spbstu.lab5.DataProv.Provider;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.spbstu.lab5.Site.MCPage;
import static com.spbstu.lab5.Site.Page;

public class TestLab5 extends TestNGBase {
    @BeforeSuite
    public void beforeSuite() {
        driverFactory.setDriverPath(DrivPath.DRIVER_PATH.Str);
        WebSite.init(Site.class);
        driverFactory.getDriver();
        WebSite.open();

     /*   driverFactory.setDriverPath("webdriver.folder");
        WebSite.init(Site.class);
        driverFactory.getDriver();*/

        Page.Login(new User(Data.LOGIN.Str, Data.PASSWORD.Str));
        Page.OpenMetalsAndColorsPage();
       // Page.CheckLogin( Data.Login, Data.Password, Data.UserName);
        MCPage.components.select("Salad");//Отменяем галочку на "Salad"
    }

    @Test(dataProvider = "provider", dataProviderClass = Provider.class)
    public void TestLab(DataForResult test) {
    //    Page.Login(new User(Data.LOGIN.Str, Data.PASSWORD.Str));
    //    Page.OpenMetalsAndColorsPage();
        MCPage.SetValues(test);
        MCPage.CheckValues(test);
        MCPage.UnsetValues(test);
    }
}
