package gui.core;

import gui.app.Actions;
import lombok.extern.slf4j.Slf4j;
@Slf4j(topic = "|Book page|")
public class BookPage extends Actions {

    public String getBookAuthor() {
        log.info("Get book author");
        return getTextOfElement(author);
    }
}
