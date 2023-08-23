package com.regiojet;


import browser.Browser;
import browser.DriverSetUp;
import org.junit.*;
import org.openqa.selenium.WebDriver;


public class RegioJetFrontTest {
    static WebDriver driver;
    LocatorsRegioJet locators = new LocatorsRegioJet();
    Browser browser = new Browser(driver);
    MainPageRegioJet mainPage = new MainPageRegioJet(driver);
    SearchPageRegioJet searchPage = new SearchPageRegioJet(driver);

    String URL = "https://regiojet.com";

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
        searchDestination();

        searchPage.selectItem(searchPage.takeDirection(locators.timeDuration));
    }

    @Test
    public void earliestDirection() throws Exception {
        searchDestination();

        searchPage.selectItem(searchPage.takeDirection(locators.timeDepartureAndArrival));
    }

    @Test
    public void lowestPrice() throws Exception {
        searchDestination();

        searchPage.selectItem(searchPage.price());
    }

    private void searchDestination() throws InterruptedException {
        browser.setUpPage(URL);
        mainPage.searchDestination("Ostrava", "Brno");
    }

}
