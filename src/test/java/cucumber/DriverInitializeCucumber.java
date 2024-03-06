package cucumber;

import browser.Browser;
import browser.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class DriverInitializeCucumber {
    protected static WebDriver driver;
    protected Browser browser = new Browser(driver);
    @BeforeClass
    public static void setUpDriver() throws Exception {
        driver = DriverSetUp.setUpDriver("chrome");
    }
    @AfterMethod
    public void quitDriver() throws Exception {
        browser.quitDriver();
        setUpDriver();
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }
}
