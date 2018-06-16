package com.spbstu.lab5;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.spbstu.lab5.Login.User;
import com.spbstu.lab5.DataProv.DataForResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.spbstu.lab5.Site.MCPage;
import static com.spbstu.lab5.Site.Page;

import com.spbstu.lab5.DataProv.DataForResult;

public class TestLab5 extends TestNGBase {
    @BeforeSuite
    public void beforeSuite() {
        driverFactory.setDriverPath(DrivPath.DRIVER_PATH.Str);
        WebSite.init(Site.class);
       // driverFactory.getDriver();
        driverFactory.getDriver();
        WebSite.open();

     /*   driverFactory.setDriverPath("webdriver.folder");
        WebSite.init(Site.class);
        driverFactory.getDriver();*/

        Page.Login(new User(Data.LOGIN.Str, Data.PASSWORD.Str));
        Page.OpenMetalsAndColorsPage();
       // Page.CheckLogin( Data.Login, Data.Password, Data.UserName);
       // Page.ServiceHeader();//переходим к MetalColors
        MCPage.Components.select("Salad");//Отменяем галочку на "Salad"
    }

    @Test(dataProvider = "provider", dataProviderClass = DataProvider.class)
    public void Test(DataForResult test) {
        MCPage.SetValues(test);
      //  MCPage.CheckValues(test);
      //  MCPage.UnsetValues(test);
    }
}
