package ui.businessLogic;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import ui.mainLogic.SearchPageBasicSteps;

import java.util.List;

@Slf4j(topic = "|Search page business steps|")
public class SearchPageBusinessSteps extends SearchPageBasicSteps {

    public void selectBookBySpecificYear(Integer year) {
        log.info("Select book by a specific year " + year);
        List<WebElement> elementList = getListOfPublishes();
        int foundIndex = getIndexYearContainsPublishes(elementList, year);
        chooseBookByIndex(foundIndex);
    }
}
