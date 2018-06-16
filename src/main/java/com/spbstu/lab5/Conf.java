package com.spbstu.lab5;

import org.aeonbits.owner.Config;
import static org.aeonbits.owner.Config.Sources;
import static org.aeonbits.owner.Config.Key;

@Sources({"classpath:test.properties"})
public interface Conf extends Config {

    @Key("homepage.url")
    String homepage();

    @Key("webdriver.chrome.driver")
    String pathToDriver();

    @Key("webdriver.folder")
    String driverFolder();
}