package com.regiojet;

import browser.DriverInitialize;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import listeners.ListenerAllureJunit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import regioJet.gui.MainPageRegioJet;
import regioJet.gui.SearchPageRegioJet;

@ExtendWith(ListenerAllureJunit.class)
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
    @Owner("Daniil Krapiunitski")
    @Description("Find shortest direction by time between 2 cities")
    public void shortestDirection() {
        int getItemDirection = searchPage.takeDirection(searchPage.timeDuration);
        searchPage.selectDirection(getItemDirection);
    }

    @Test
    @Owner("Daniil Krapiunitski")
    @Description("Find shortest earliest direction from arrival city")
    public void earliestDirection() {
        int getItemDirection = searchPage.takeDirection(searchPage.timeDepartureAndArrival);
        searchPage.selectDirection(getItemDirection);
    }

    @Test
    @Owner("Daniil Krapiunitski")
    @Description("Find minimal price of trip between 2 cities")
    public void lowestPrice() {
        int getItemDirection = searchPage.getMinimumPrice();
        searchPage.selectDirection(getItemDirection);
    }

}
