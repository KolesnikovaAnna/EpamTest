package com.spbstu.lab5;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.spbstu.lab5.Login.TestPage;


@JSite("https://jdi-framework.github.io/tests/")
public class Site extends WebSite {
    public static TestPage Page;
    public static MetalsColors MCPage;
}
