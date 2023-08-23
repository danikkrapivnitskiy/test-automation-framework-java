package cz.idos;


import browser.Browser;
import browser.DriverSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class IdosTest {
    static WebDriver driver;
    LocatorsIdos locators = new LocatorsIdos();
    Browser browser = new Browser(driver);
    MainPageIdos mainPage = new MainPageIdos(driver);
    SearchPageIdos searchPage = new SearchPageIdos(driver);
    String URL = "https://www.idos.cz/";

//    @BeforeClass
//    public static void setUpDriver() throws Exception {
//        driver = DriverSetUp.setUpDriver("chrome");
//    }
//
//    @After
//    public void quitDriver() throws Exception {
//        browser.quitDriver();
//        setUpDriver();
//    }
//
//    @AfterClass
//    public static void closeDriver() {
//        driver.close();
//    }

    @Test
    public void tomorrowConnections() throws Exception {
        browser.setUpPage(URL);
        mainPage.searchDestination("Praha", "Brno");

        searchPage.verifyDateAndTime();
    }

    @Test
    public void setBrowser() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.idos.cz/");
    }

}
