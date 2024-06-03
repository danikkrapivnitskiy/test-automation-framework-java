package ui.app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Actions extends Locators {
    public Actions setDepartureDestination(String fromStr) {
        sendKeys(from, fromStr);
        sendKeys(from, Keys.ENTER);
        return this;
    }
    public void setArrivalDestination(String toStr) {
        sendKeys(to, toStr);
        sendKeys(to, Keys.ENTER);
    }
    public void openCalendar() {
        clickOnElement(departure);
    }
    public void clickSearchDestination() {
        submitElement(search);
    }
    public List<WebElement> getListOfTrip() {
        return getListOfElements(selectItem);
    }
    protected String getDepartureAndArrivalTime(int index) {
        return getTextOfElement(By.xpath(String.format("%s[%d]", timeDepartureAndArrivalStr, index + 1)));
    }
    protected String getPrice(int index) {
        return getTextOfElement(By.xpath(String.format("%s[%d]", selectItemStr, index + 1)));
    }
}
