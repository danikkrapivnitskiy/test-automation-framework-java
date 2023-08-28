package cucumber;

import browser.Browser;
import cz.idos.MainPageIdos;
import cz.idos.SearchPageIdos;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static cucumber.DriverInitializeCucumber.driver;

public class IdosCucumber {
    MainPageIdos mainPage = new MainPageIdos(driver);
    SearchPageIdos searchPage = new SearchPageIdos(driver);

    protected Browser browser = new Browser(driver);

    @Given("Open the page {string}")
    public void setUpPage(String url) {
        browser.setUpPage(url);
    }

    @When("Search destination from {string} to {string}")
    public void searchDestination(String from, String to) throws InterruptedException {
        mainPage.searchDestination(from, to);
    }

    @And("Verify date and time")
    public void verifyDateAndTime(){
        searchPage.verifyDateAndTime();
    }

    @Then("Give information about the trip")
    public void informationOfTrip() {
        searchPage.informationOfTrip();
    }


}
