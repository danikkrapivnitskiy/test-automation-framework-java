package gui.app;

import org.openqa.selenium.By;
import ui.BaseDriverMethods;

public class Locators extends BaseDriverMethods {
    protected final By languageDropDown = By.className("language-component");
    protected final By specificLanguage = By.xpath("//div[@class='language-dropdown-component']//li");
    protected final By searchInput = By.xpath("//input[@placeholder='Search']");
    protected final By publishYear = By.className("publishedYear");
    protected final String listBooksOfAuthor = "(//h3[@class='booktitle']//a[@class='results'])";
    protected final By author = By.xpath("//div[@class='work-title-and-author desktop']//a[@itemprop='author']");
}
