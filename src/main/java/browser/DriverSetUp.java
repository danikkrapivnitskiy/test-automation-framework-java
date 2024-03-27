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
    @SneakyThrows
    public static WebDriver setUpDriver(String browser) {
        log.info("Setup browser " + browser);
        WebDriver driver = getDriver(browser);
        switch (browser){
            case "chrome": {
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;
            }
            case "firefox": {
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        return driver;
    }

    public static WebDriver getDriver(String browser) throws Exception {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else throw new Exception("Not correct browser");
        return driver;
    }
}
