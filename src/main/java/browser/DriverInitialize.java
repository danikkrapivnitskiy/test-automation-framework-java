package browser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class DriverInitialize extends WebDriverFactory {
    public static WebDriver driver;
    @BeforeEach
    public void setUpDriver() {
        driver = setUpDriver(Browser.CHROME.getName());
    }

    @AfterEach
    public void closeDriver() {
        quitDriver();
    }
}
