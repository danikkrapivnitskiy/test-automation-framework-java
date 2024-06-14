package ui.mainLogic;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.BaseDriverMethods;

import java.util.List;
@Slf4j(topic = "|Search page basic steps|")
public class SearchPageBasicSteps extends BaseDriverMethods {
    // Selector for training
    protected final String connectionDetails = "(//a[@class='ext-expand ico-up']" +
            "//ancestor::div[@class='connection-head']/following-sibling::div[@class='connection-details ']" +
            "//ul[@class='reset stations first last'])";
    protected final String timeOfStation = "//p[@class='reset time ']";
    protected final String nameOfStation = "//p[@class='station']";
    // Selector for training
    protected final By price = By.xpath("(//a[@class='ext-expand ico-up']" +
            "//ancestor::div[@class='connection-head']/following-sibling::div[@class='connection-expand']" +
            "//child::span[@class='price-skipped'])");
    protected final By priceErrorMsg = By.xpath("//span[@title = 'Cenu se nepodařilo získat']");
    protected final By timeAndDateDeparture = By.xpath("(//h2[@class='reset date'])");
    protected final By detailOfTrip = By.xpath("(//li[@class='expand']//a[@class='ext-expand ico-down'])");

    public List<WebElement> getTripDetails() {
        return getListOfElements(detailOfTrip);
    }

    protected List<WebElement> getListStationTime(int count) {
        log.info("Get list of stations time");
        String timeStr = String.format(connectionDetails + "[%d]/li" + timeOfStation, count + 1);
        return getListOfElements(By.xpath(timeStr));
    }

    protected List<WebElement> getListStationName(int count) {
        log.info("Get list of stations name");
        String nameStr = String.format(connectionDetails + "[%d]/li" + nameOfStation, count + 1);
        return getListOfElements(By.xpath(nameStr));
    }

    protected String getPrice(int count) {
        return getListOfElements(price).get(count).getText();
    }

    protected List<WebElement> getListOfDepartureAndArrivalTime() {
        return getListOfElements(timeAndDateDeparture);
    }
}
