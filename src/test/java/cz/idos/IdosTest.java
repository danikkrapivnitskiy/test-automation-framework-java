package cz.idos;

import browser.DriverInitialize;
import listeners.ListenerAllureJunit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ListenerAllureJunit.class)
public class IdosTest extends DriverInitialize {
    private MainPageIdos mainPage;
    private SearchPageIdos searchPage;
    private final String URL = "https://www.idos.cz/";

    @BeforeEach
    public void searchDestination() {
        mainPage = new MainPageIdos();
        searchPage = new SearchPageIdos();
        mainPage.setupPage(URL);
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
