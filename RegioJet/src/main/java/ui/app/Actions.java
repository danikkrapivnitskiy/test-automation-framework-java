package ui.app;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
@Slf4j(topic = "|Actions RegioJet|")
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
