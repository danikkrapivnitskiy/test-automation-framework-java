package ui;

import configuration.ConfigProperties;
import listeners.ListenerAllureJunit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ui.businessLogic.MainPageBusinessSteps;
import ui.businessLogic.SearchPageBusinessSteps;

@ExtendWith(ListenerAllureJunit.class)
public class IdosTest extends BaseTestSetUp {
    private SearchPageBusinessSteps searchPage;

    @BeforeEach
    public void searchDestination() {
        MainPageBusinessSteps mainPage = new MainPageBusinessSteps();
        searchPage = new SearchPageBusinessSteps();
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
