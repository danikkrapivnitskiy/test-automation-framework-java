package gui.core;

import gui.app.Actions;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "|Base Page|")
public class BasePage extends Actions {

    public void navigateToMainPage(String url) {
        setupPageAndApplyCookies(url, null);
    }

    public void findBookByName(String book) {
        searchTheBook(book);
    }

    public void setWebsiteToSpecificLanguage(String language) {
        setWebAllocation(language);
    }
}
