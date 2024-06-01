package idos;

import browserSetUp.DriverInitialize;
import project.support.configuration.ConfigProperties;
import project.support.listeners.ListenerAllureJunit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import projects.idos.MainPageIdos;
import projects.idos.SearchPageIdos;

@ExtendWith(ListenerAllureJunit.class)
public class IdosTest extends DriverInitialize {
    private MainPageIdos mainPage;
    private SearchPageIdos searchPage;

    @BeforeEach
    public void searchDestination() {
        mainPage = new MainPageIdos();
        searchPage = new SearchPageIdos();
        mainPage.setupPage(ConfigProperties.getIdosUrl());
        mainPage.searchDestination("Praha", "Brno");
    }

    @Test
    public void verifyDateAndTimeForAllDirectionAfterSpecificTime() {
        searchPage.verifyDateAndTimeDeparture(8, 0);
    }

    @Test
    public void logStopsTimePriceAndDurationForEachDirection(){
        searchPage.getInformationOfTrip(true);
    }
}
