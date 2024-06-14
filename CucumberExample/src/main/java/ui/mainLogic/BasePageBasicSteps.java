package ui.mainLogic;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ui.BaseDriverMethods;

import java.util.List;
@Slf4j(topic = "|Base page basic steps|")
public class BasePageBasicSteps extends BaseDriverMethods {
    protected final By languageDropDown = By.className("language-component");
    protected final By specificLanguage = By.xpath("//div[@class='language-dropdown-component']//li");
    protected final By searchInput = By.xpath("//input[@placeholder='Search']");
    protected void searchTheBook(String book) {
        log.info("Search book by name " + book);
        sendKeys(searchInput, Keys.chord(book, Keys.ENTER));
    }

    protected void setWebAllocation(String language) {
        log.info("Set web allocation to " + language);
        clickOnElement(languageDropDown);
        List<WebElement> elementList = getListOfElements(specificLanguage);
        elementList.stream()
                .filter(element -> element.getText().startsWith(language))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void closeBrowser() {
        quitDriver();
    }
}
