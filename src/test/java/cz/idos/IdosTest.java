package cz.idos;


import browser.DriverInitialize;
import org.junit.Test;


public class IdosTest extends DriverInitialize {
    MainPageIdos mainPage = new MainPageIdos(driver);
    SearchPageIdos searchPage = new SearchPageIdos(driver);
    String URL = "https://www.idos.cz/";

    @Test
    public void verifyDateAndTime() throws Exception {
        searchDestination();

        searchPage.verifyDateAndTime();
    }

    @Test
    public void informationOfTrip() throws InterruptedException {
        searchDestination();

        searchPage.informationOfTrip();
    }

    private void searchDestination() throws InterruptedException {
        browser.setUpPage(URL);
        mainPage.searchDestination("Praha", "Brno");
    }

}
