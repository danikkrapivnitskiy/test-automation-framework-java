package ui.app;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
@Slf4j(topic = "|Actions Idos|")
public class Actions extends Locators {

    public Actions chooseTomorrowDate() {
        log.info("Choose tomorrow date");
        clickOnElement(tomorrow);
        return this;
    }

    public Actions setDepartureTime(String timeStr) {
        log.info("Set departure time {}", timeStr);
        sendKeys(time, timeStr);
        return this;
    }

    public Actions setDepartureDestination(String departure) {
        log.info("Set departure destination {}", departure);
        sendKeys(from, departure);
        return this;
    }

    public Actions setArrivalDestination(String arrival) {
        log.info("Set departure arrival {}", arrival);
        sendKeys(to, arrival);
        return this;
    }

    public void submitSearchDestination() {
        submitElement(search);
    }

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
