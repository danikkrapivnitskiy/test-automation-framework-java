package com.regiojet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) throws Exception {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "driver\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions co = new ChromeOptions();
            co.setBinary("driver\\chrome-win64\\chrome.exe");
            return new ChromeDriver(co);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else throw new Exception("Not correct browser");
    }

}
