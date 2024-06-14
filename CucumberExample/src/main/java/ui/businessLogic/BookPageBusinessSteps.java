package ui.businessLogic;

import lombok.extern.slf4j.Slf4j;
import ui.mainLogic.BookPageBasicSteps;

@Slf4j(topic = "|Book page|")
public class BookPageBusinessSteps extends BookPageBasicSteps {

    public String getBookAuthor() {
        log.info("Get book author");
        return getTextOfElement(author);
    }
}
