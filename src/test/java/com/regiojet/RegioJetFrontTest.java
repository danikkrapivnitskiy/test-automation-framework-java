package com.regiojet;

import browser.DriverInitialize;
import extension.FailedTestScreenshotExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import regioJet.gui.MainPageRegioJet;
import regioJet.gui.SearchPageRegioJet;

@ExtendWith(FailedTestScreenshotExtension.class)
public class RegioJetFrontTest extends DriverInitialize {
    MainPageRegioJet mainPage;
    SearchPageRegioJet searchPage;
    String URL = "https://regiojet.com";

    @BeforeEach
    public void searchDestination() {
        mainPage = new MainPageRegioJet();
        searchPage = new SearchPageRegioJet();
        mainPage.setupPage(URL);
        mainPage.searchDestination("Ostrava", "Brno");
    }

    @Test
    public void shortestDirection() {
        int getItemDirection = searchPage.takeDirection(searchPage.timeDuration);
        searchPage.selectDirection(getItemDirection);
    }

    @Test
    public void earliestDirection() {
        int getItemDirection = searchPage.takeDirection(searchPage.timeDepartureAndArrival);
        searchPage.selectDirection(getItemDirection);
    }

    @Test
    public void lowestPrice() {
        int getItemDirection = searchPage.getMinimumPrice();
        searchPage.selectDirection(getItemDirection);
    }

}
