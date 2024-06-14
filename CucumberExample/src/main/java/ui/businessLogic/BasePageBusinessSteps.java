package ui.businessLogic;

import lombok.extern.slf4j.Slf4j;
import ui.mainLogic.BasePageBasicSteps;

@Slf4j(topic = "|Base Page business steps|")
public class BasePageBusinessSteps extends BasePageBasicSteps {

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
