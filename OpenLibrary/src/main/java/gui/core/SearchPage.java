package gui.core;

import gui.app.Actions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j(topic = "|SearchPage|")
public class SearchPage extends Actions {

    public void selectBookBySpecificYear(Integer year) {
        log.info("Select book by a specific year " + year);
        List<WebElement> elementList = getListOfPublishes();
        int foundIndex = getIndexYearContainsPublishes(elementList, year);
        chooseBookByIndex(foundIndex);
    }
}
