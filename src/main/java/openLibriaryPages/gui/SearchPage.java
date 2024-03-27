package openLibriaryPages.gui;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j(topic = "|SearchPage|")
public class SearchPage {
    private final By publishYear = By.className("publishedYear");
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBookBySpecificYear(Integer year) {
        log.info("Select book by a specific year");
        List<WebElement> elementList = driver.findElements(publishYear);
        int foundIndex = IntStream.range(0, elementList.size())
                .filter(i -> elementList.get(i).getText().contains(year.toString()))
                .findFirst().getAsInt();
        WebElement element = driver.findElement(By.xpath("//h3[@class='booktitle']//a[@class='results'][" + (foundIndex + 1) + "]"));
        element.click();
    }


}
