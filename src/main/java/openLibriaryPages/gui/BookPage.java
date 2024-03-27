package openLibriaryPages.gui;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Slf4j(topic = "|Book page|")
public class BookPage {
    private By author = By.xpath("//div[@class='work-title-and-author desktop']//a[@itemprop='author']");
    private WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAuthorOfBook() {
        log.info("Get author for specific book");
        return driver.findElement(author).getText();
    }
}
