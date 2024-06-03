package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTestSetUp extends WebDriverFactory {

    @BeforeEach
    public void setUpDriverBeforeTest() {
        driver = setUpDriver();
    }

    @AfterEach
    public void closeDriver() {
        quitDriver();
    }
}
