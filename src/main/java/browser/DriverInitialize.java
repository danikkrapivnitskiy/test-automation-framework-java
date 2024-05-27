package browser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class DriverInitialize {
    public static WebDriver driver;
    @BeforeEach
    public void setUpDriver() {
        driver = DriverSetUp.setUpDriver("chrome");
    }

    @AfterEach
    public void closeDriver() {
        DriverSetUp.quitDriver();
    }
}
