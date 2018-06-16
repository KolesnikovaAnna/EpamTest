package com.spbstu.lab4;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Allure extends TestListenerAdapter {
        @Attachment(value = "Fail screen", type = "image/png")
        public byte[] MakeScreen() {
            byte[] array = {1};
            try {
                return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
            return array;
        }
        @Override
        public void onTestFailure(ITestResult iTestResult) {
            MakeScreen();
        }
        @Override
        public void onTestSuccess(ITestResult iTestResult) {
            MakeScreen();
        }
}
