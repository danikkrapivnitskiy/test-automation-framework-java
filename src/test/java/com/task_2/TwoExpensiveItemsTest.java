package com.task_2;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import task_2.*;


public class TwoExpensiveItemsTest {
    static WebDriver driver;
    Locators locators = new Locators();
    Browser browser = new Browser(driver);
    MainPage mainPage = new MainPage(driver);
    CategoryPage categoryPage = new CategoryPage(driver);

    @BeforeClass
    public static void setUpDriver() throws Exception {
        driver = DriverSetUp.setUpDriver("chrome");
    }

    @After
    public void quitDriver() throws InterruptedException {
        browser.quitDriver();
    }

    @Test
    public void chooseItems() throws Exception {
        browser.setUpPage();
        mainPage.switchToCategory(locators.desksForHome);
        categoryPage.selectTwoExpensiveItems();
    }
}
