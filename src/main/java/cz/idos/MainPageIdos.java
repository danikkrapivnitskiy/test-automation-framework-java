package cz.idos;

import interfaces.MethodsMainPage;
import org.openqa.selenium.WebDriver;

public class MainPageIdos implements MethodsMainPage {

    WebDriver driver;
    LocatorsIdos locators = new LocatorsIdos();
    public MainPageIdos(WebDriver driver){
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
        Thread.sleep(1000);
    }
}

