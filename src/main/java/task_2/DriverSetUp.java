package task_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
                driver.manage().window().setSize(new Dimension(400, 500));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        return driver;
    }
}
