package gui.app;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j(topic = "|Actions|")
public class Actions extends Locators {
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

    protected List<WebElement> getListOfPublishes() {
        log.info("Get list of publishes");
        return getListOfElements(publishYear);
    }

    protected int getIndexYearContainsPublishes(List<WebElement> elementList, Integer year) {
        return IntStream.range(0, elementList.size())
                .filter(i -> elementList.get(i).getText().contains(year.toString()))
                .findFirst().getAsInt();
    }

    protected void chooseBookByIndex(int foundIndex) {
        log.info("Choose book by index");
        clickOnElement(By.xpath(String.format(listBooksOfAuthor + "[%d]", (foundIndex + 1))));
    }

    public void closeBrowser() {
        quitDriver();
    }
}
