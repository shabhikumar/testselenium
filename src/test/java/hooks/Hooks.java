package hooks;

import DataProviders.ConfigFileReader;
import Managers.AllDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Hooks {
    public static WebDriver driver;

    AllDriverManager allDriverManager = new AllDriverManager();
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Before
    public void setup() {
        try {
            driver = allDriverManager.getDriver();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  static WebDriver getDriver() {
        return driver;
    }

    public void launchBrowser() {
        driver.get(configFileReader.getUrl());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}