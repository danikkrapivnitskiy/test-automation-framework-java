package task_2;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Browser {

    WebDriver driver ;
    Locators locators = new Locators();

    public Browser(WebDriver driver){
        this.driver=driver;
    }


    public void setUpPage() {
        driver.get("https://www.ikea.com/cz/en/cat/desks-computer-desks-20649/");
        if (driver.findElement(locators.acceptCookies).isDisplayed()){
            driver.findElement(locators.acceptCookies).click();
        }
    }

    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
