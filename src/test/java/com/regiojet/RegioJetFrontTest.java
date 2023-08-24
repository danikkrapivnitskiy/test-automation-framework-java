package com.regiojet;


import browser.Browser;
import browser.DriverInitialize;
import browser.DriverSetUp;
import org.junit.*;
import org.openqa.selenium.WebDriver;


public class RegioJetFrontTest extends DriverInitialize {
    LocatorsRegioJet locators = new LocatorsRegioJet();
    MainPageRegioJet mainPage = new MainPageRegioJet(driver);
    SearchPageRegioJet searchPage = new SearchPageRegioJet(driver);

    String URL = "https://regiojet.com";



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
