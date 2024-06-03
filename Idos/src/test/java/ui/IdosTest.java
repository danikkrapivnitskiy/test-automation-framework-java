package ui;

import configuration.ConfigProperties;
import listeners.ListenerAllureJunit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ui.core.MainPageIdos;
import ui.core.SearchPageIdos;

@ExtendWith(ListenerAllureJunit.class)
public class IdosTest extends BaseTestSetUp {
    private SearchPageIdos searchPage;

    @BeforeEach
    public void searchDestination() {
        MainPageIdos mainPage = new MainPageIdos();
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
        searchPage.getInformationOfTrip();
    }
}
