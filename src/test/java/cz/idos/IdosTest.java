package cz.idos;


import browser.Browser;
import browser.DriverSetUp;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class IdosTest {
    static WebDriver driver;
    LocatorsIdos locators = new LocatorsIdos();
    Browser browser = new Browser(driver);
    MainPageIdos mainPage = new MainPageIdos(driver);
    SearchPageIdos searchPage = new SearchPageIdos(driver);
    String URL = "https://www.idos.cz/";

    @BeforeClass
    public static void setUpDriver() throws Exception {
        driver = DriverSetUp.setUpDriver("chrome");
    }

    @After
    public void quitDriver() throws Exception {
        browser.quitDriver();
        setUpDriver();
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @Test
    public void verifyDateAndTime() throws Exception {
        browser.setUpPage(URL);
        mainPage.searchDestination("Praha", "Brno");

        searchPage.verifyDateAndTime();
    }

    @Test
    public void informationOfTrip() throws InterruptedException {
        browser.setUpPage(URL);
        mainPage.searchDestination("Praha", "Brno");

        searchPage.informationOfTrip();
    }

}
