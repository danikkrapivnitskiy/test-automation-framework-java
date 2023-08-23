package com.regiojet;

import main.MethodsMainPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public class MainPageRegioJet extends MethodsMainPage {

    WebDriver driver;
    LocatorsRegioJet locators = new LocatorsRegioJet();

    Date date = new Date();
    Calendar calendar = Calendar.getInstance();

    public MainPageRegioJet(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    @Override
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

