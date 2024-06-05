package ui;

import configuration.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
@Slf4j(topic = "|WebDriverFactory|")
public class WebDriverFactory {

    protected static WebDriver driver;
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    protected WebDriver getDriver(String browser) throws Exception {
        switch (browser) {
            case CHROME -> {
                // Some issue with web driver manager downloading
//                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                addChromeOptions(chromeOptions);
                driver = new ChromeDriver(chromeOptions);
            }
            case FIREFOX -> {
//                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> throw new Exception("Not correct browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driverThreadLocal.set(driver);
        return driver;
    }

    @SneakyThrows
    public WebDriver setUpDriver() {
        String browser = System.getProperty("-DbrowserType", ConfigProperties.getProperty("browserType"));
        log.info("Setup driver " + browser);
        return getDriver(browser);
    }

    public static void quitDriver() {
        if (driver != null) {
            log.info("Driver closed");
            driver.quit();
        }
    }

    private void addChromeOptions(ChromeOptions chromeOptions) {
        if (System.getProperty("-Dheadless", "false").equals("true")) {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.addArguments("--disable-gpu");
    }
}
