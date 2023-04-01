package com.regiojet;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MainPage {

    WebDriver driver;
    Locators locators = new Locators();

    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    @Step
    public void searchDestination(String from, String to) throws InterruptedException {
        driver.findElement(locators.from).sendKeys(from);
        Thread.sleep(1000);
        driver.findElement(locators.from).sendKeys(Keys.ENTER);
        driver.findElement(locators.to).sendKeys(to);
        Thread.sleep(1000);
        driver.findElement(locators.to).sendKeys(Keys.ENTER);
        driver.findElement(locators.departure).click();
        driver.findElement(locators.mondayDeparture).click();
        driver.findElement(locators.search).submit();
    }
}

