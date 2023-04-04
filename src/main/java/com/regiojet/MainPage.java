package com.regiojet;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public class MainPage {

    WebDriver driver;
    Locators locators = new Locators();

    Date date = new Date();
    Calendar calendar = Calendar.getInstance();

    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    public void searchDestination(String from, String to) throws InterruptedException {
        calendar.setTime(date);

        driver.findElement(locators.from).sendKeys(from);
        Thread.sleep(1000);
        driver.findElement(locators.from).sendKeys(Keys.ENTER);

        driver.findElement(locators.to).sendKeys(to);
        Thread.sleep(1000);
        driver.findElement(locators.to).sendKeys(Keys.ENTER);

        driver.findElement(locators.departure).click();
        Thread.sleep(500);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            driver.findElement(locators.today).click();
        } else driver.findElement(locators.mondayDeparture).click();
        driver.findElement(locators.search).submit();
    }
}

