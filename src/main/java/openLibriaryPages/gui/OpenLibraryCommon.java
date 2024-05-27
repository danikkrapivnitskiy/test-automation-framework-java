package openLibriaryPages.gui;

import browser.DriverMethods;
import browser.DriverSetUp;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j(topic = "|Open Library Common functions|")
public class OpenLibraryCommon {
    private final By languageDropDown = By.className("language-component");
    private final By specificLanguage = By.xpath("//div[@class='language-dropdown-component']//li");
    private final By searchInput = By.xpath("//input[@placeholder='Search']");
    private final WebDriver driver;
    protected DriverMethods driverMethods = new DriverMethods();

    public OpenLibraryCommon(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToMainPage(String url) {
        log.info("Navigate to main page");
        driverMethods.setupPage(url, null);
    }

    public void searchTheBook(String book) {
        log.info("Find book: " + book);
        driverMethods.sendKeys(searchInput, Keys.chord(book, Keys.ENTER));
    }

    public void setWebsiteToSpecificLanguage(String language) {
        log.info("Set website to specific language: " + language);
        driverMethods.clickOnElement(languageDropDown);
        List<WebElement> elementList = driver.findElements(specificLanguage);
        elementList.stream()
                .filter(element -> element.getText().startsWith(language))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void closeBrowser() {
        DriverSetUp.quitDriver();
    }
}
