package ui.mainLogic;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.BaseDriverMethods;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
@Slf4j(topic = "|Search page basic steps|")
public class SearchPageBasicSteps extends BaseDriverMethods {
    public final By timeDuration = By.xpath("//span[@class='text-13 lg:text-14']");
    protected final String selectItemStr = "(//span[@class='text-13 lg:text-14']//../../div[2])";
    protected final By selectItem = By.xpath(selectItemStr);
    protected final String timeDepartureAndArrivalStr = "(//h2[@class='h3'])";
    public final By timeDepartureAndArrival = By.xpath("(//h2[@class='h3'])");
    public List<WebElement> getListOfTrip() {
        return getListOfElements(selectItem);
    }
    protected String getDepartureAndArrivalTime(int index) {
        return getTextOfElement(By.xpath(String.format("%s[%d]", timeDepartureAndArrivalStr, index + 1)));
    }
    protected String getPrice(int index) {
        return getTextOfElement(By.xpath(String.format("%s[%d]", selectItemStr, index + 1)));
    }

    protected Optional<LocalTime> extractTimeFromElement(WebElement element) {
        String timeStr = element.getText();
        log.info("Parsing time string: {}", timeStr);
        try {
            return Optional.of(LocalTime.parse(timeStr.substring(0, 5)));
        } catch (Exception e) {
            log.warn("Error parsing time string: {}", timeStr);
            return Optional.empty();
        }
    }

    protected int extractPrice(String priceStr) {
        log.warn("Return price");
        String numberOnly = priceStr.replaceAll("\\D+", "");
        return numberOnly.isEmpty() ? 0 : Integer.parseInt(numberOnly);
    }
}
