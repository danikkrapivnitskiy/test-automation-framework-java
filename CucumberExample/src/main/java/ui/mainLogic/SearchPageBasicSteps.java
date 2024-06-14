package ui.mainLogic;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;
@Slf4j(topic = "|Search page basic steps|")
public class SearchPageBasicSteps extends BasePageBasicSteps {
    protected final By publishYear = By.className("publishedYear");
    protected final String listBooksOfAuthor = "(//h3[@class='booktitle']//a[@class='results'])";
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
}
