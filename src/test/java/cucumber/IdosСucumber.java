package cucumber;

import browser.DriverInitialize;
import cz.idos.MainPageIdos;
import cz.idos.SearchPageIdos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Test;

public class IdosСucumber extends DriverInitialize {
    MainPageIdos mainPage = new MainPageIdos(driver);
    SearchPageIdos searchPage = new SearchPageIdos(driver);

    @Given("Open the page {string} and search destination from {string} to {string}")
    public void searchDestination(String URL, String from, String to) throws InterruptedException {
        browser.setUpPage(URL);
        mainPage.searchDestination(from, to);
    }

    @When("Open page")
    public void verifyDateAndTime(){
        searchPage.verifyDateAndTime();
    }


}
