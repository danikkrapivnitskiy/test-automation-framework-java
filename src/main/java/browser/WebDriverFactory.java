package browser;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
@Slf4j(topic = "|WebDriverFactory|")
public class WebDriverFactory {

    static WebDriver driver;
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    protected static WebDriver getDriver(String browser) throws Exception {
        switch (browser) {
            case CHROME -> {
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                driver = new FirefoxDriver();
            }
            default -> throw new Exception("Not correct browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    @SneakyThrows
    public static WebDriver setUpDriver(String browser) {
        log.info("Setup driver " + browser);
        return getDriver(browser);
    }

    public static void quitDriver() {
        if (driver != null) {
            log.info("Driver closed");
            driver.quit();
        }
    }
}
