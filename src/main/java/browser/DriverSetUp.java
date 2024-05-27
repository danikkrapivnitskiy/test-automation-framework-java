package browser;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
@Slf4j(topic = "|DriverSetUp|")
public class DriverSetUp {

    static WebDriver driver;

    protected static WebDriver getDriver(String browser) throws Exception {
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
            default -> throw new Exception("Not correct browser");
        }
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
