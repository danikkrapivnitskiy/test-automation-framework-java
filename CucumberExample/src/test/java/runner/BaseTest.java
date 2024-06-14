package runner;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import ui.WebDriverFactory;

public class BaseTest {
    protected static WebDriver driver;
    @Before
    void setUpDriver() {
        driver = new WebDriverFactory().setUpDriver();
    }

    @AfterAll
    void closeDriver() {
        WebDriverFactory.quitDriver();
    }
}
