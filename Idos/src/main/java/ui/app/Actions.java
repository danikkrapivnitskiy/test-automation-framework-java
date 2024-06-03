package ui.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Actions extends Locators {

    public Actions chooseTomorrowDate() {
        clickOnElement(tomorrow);
        return this;
    }

    public Actions setDepartureTime(String timeStr) {
        sendKeys(time, timeStr);
        return this;
    }

    public Actions setDepartureDestination(String departure) {
        sendKeys(from, departure);
        return this;
    }

    public Actions setArrivalDestination(String arrival) {
        sendKeys(to, arrival);
        return this;
    }

    public void submitSearchDestination() {
        submitElement(search);
    }

    public List<WebElement> getTripDetails() {
        return getListOfElements(detailOfTrip);
    }

    protected List<WebElement> getTimeElements(int count) {
        String timeStr = String.format(connectionDetails + "[%d]/li" + timeOfStation, count + 1);
        return getListOfElements(By.xpath(timeStr));
    }

    protected List<WebElement> getNameElements(int count) {
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
