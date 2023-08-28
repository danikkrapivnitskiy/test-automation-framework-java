package cucumber;

import browser.Browser;
import browser.DriverSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class DriverInitializeCucumber {
    protected static WebDriver driver;
    protected Browser browser = new Browser(driver);
    @BeforeAll
    public static void setUpDriver() throws Exception {
        driver = DriverSetUp.setUpDriver("chrome");
    }
    @After
    public void quitDriver() throws Exception {
        browser.quitDriver();
        setUpDriver();
    }

    @AfterAll
    public static void closeDriver() {
        driver.close();
    }
}
