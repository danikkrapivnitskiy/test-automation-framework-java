package com.regiojet;


import browser.Browser;
import browser.DriverSetUp;
import org.junit.*;
import org.openqa.selenium.WebDriver;


public class RegioJetFrontTest {
    static WebDriver driver;
    Locators locators = new Locators();
    Browser browser = new Browser(driver);
    MainPage mainPage = new MainPage(driver);
    SearchPage searchPage = new SearchPage(driver);

    @BeforeClass
    public static void setUpDriver() throws Exception {
        driver = DriverSetUp.setUpDriver("chrome");
    }

    @After
    public void quitDriver() throws Exception {
        browser.quitDriver();
        setUpDriver();
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @Test
    public void shortestDirection() throws Exception {
        browser.setUpPage();
        mainPage.searchDestination("Ostrava", "Brno");

        searchPage.selectItem(searchPage.takeDirection(locators.timeDuration));
    }

    @Test
    public void earliestDirection() throws Exception {
        browser.setUpPage();
        mainPage.searchDestination("Ostrava", "Brno");

        searchPage.selectItem(searchPage.takeDirection(locators.timeDepartureAndArrival));
    }

    @Test
    public void lowestPrice() throws Exception {
        browser.setUpPage();
        mainPage.searchDestination("Ostrava", "Brno");

        searchPage.selectItem(searchPage.price());
    }

}
