package browser;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverSetUp {

    public static WebDriver setUpDriver(String browser) throws Exception {
        WebDriver driver = DriverFactory.getDriver(browser);
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
}
