package cz.idos;

import main.MethodsMainPage;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public class MainPageIdos extends MethodsMainPage {

    WebDriver driver;
    LocatorsIdos locators = new LocatorsIdos();

    Date date = new Date();
    Calendar calendar = Calendar.getInstance();

    public MainPageIdos(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    @Override
    public void searchDestination(String from, String to) throws InterruptedException {

        driver.findElement(locators.tomorrow).click();
        Thread.sleep(500);

        driver.findElement(locators.time).sendKeys("08:00");
        Thread.sleep(500);

        driver.findElement(locators.from).sendKeys(from);
        Thread.sleep(1000);

        driver.findElement(locators.to).sendKeys(to);
        Thread.sleep(1000);

        driver.findElement(locators.search).submit();
    }
}

