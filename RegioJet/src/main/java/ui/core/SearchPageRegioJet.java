package ui.core;

import interfaces.MethodsSearchPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ui.app.Actions;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j(topic = "|Search page RegioJet|")
public class SearchPageRegioJet extends Actions implements MethodsSearchPage {

    public int takeDirection(By locator) {
        List<WebElement> elements = getListOfElements(locator);
        log.info("Found {} trip elements", elements.size());
        Assert.assertFalse(elements.isEmpty(), "No trips available for the selected route");

        Optional<LocalTime> minTime = elements.stream().map(webElement -> {
                    String timeStr = webElement.getText();
                    log.info("Parsing time string: {}", timeStr);
                    try {
                        return LocalTime.parse(timeStr.substring(0, 5));
                    } catch (Exception e) {
                        log.warn("Error parsing time string: {}", timeStr);
                        return LocalTime.MAX;
                    }
                })
                .filter(time -> !time.equals(LocalTime.MAX))
                .min(Comparator.naturalOrder());

        int minIndex = minTime.map(time -> {
            for (int i = 0; i < elements.size(); i++) {
                if (extractTimeFromElement(elements.get(i)).orElse(LocalTime.MAX).equals(time)) {
                    return i;
                }
            }
            return -1;
        }).orElse(-1);

        log.info("Found the trip at index {}", minIndex);
        log.info("Departure and arrival time: {}", getDepartureAndArrivalTime(minIndex));
        log.info("Price of the trip: {}", getPrice(minIndex));

        return minIndex;
    }

    private Optional<LocalTime> extractTimeFromElement(WebElement element) {
        String timeStr = element.getText();
        log.info("Parsing time string: {}", timeStr);
        try {
            return Optional.of(LocalTime.parse(timeStr.substring(0, 5)));
        } catch (Exception e) {
            log.warn("Error parsing time string: {}", timeStr);
            return Optional.empty();
        }
    }

    public void selectDirection(int index) {
        List<WebElement> elements = getListOfTrip();
        log.info("Found {} trip elements", elements.size());
        Assert.assertFalse(elements.isEmpty(), "No trips available for the selected route");
        Assert.assertTrue(index >= 0 && index < elements.size(), "Invalid index: " + index);

        elements.get(index).click();
        log.info("Selecting trip at index {}", index);
    }

    public int getMinimumPrice() {
        List<WebElement> elements = getListOfTrip();
        log.info("Found {} trip elements", elements.size());
        Assert.assertFalse(elements.isEmpty(), "No trips available for the selected route");

        List<Integer> priceList = new ArrayList<>();
        int lowestPrice = Integer.MAX_VALUE;

        for (WebElement element : elements) {
            String priceStr = element.getText();
            log.info("Parsing price string: {}", priceStr);
            int price = extractPrice(priceStr);
            log.info("Price at index {} is {}", elements.indexOf(element), price);
            priceList.add(price);

            if (price < lowestPrice) {
                lowestPrice = price;
            }
        }
        int indexPrice = priceList.indexOf(lowestPrice);
        log.info("Departure and arrival time: {}", getDepartureAndArrivalTime(indexPrice));
        log.info("Price of the cheapest trip: {}", getPrice(indexPrice));

        return indexPrice;
    }

    private int extractPrice(String priceStr) {
        String numberOnly = priceStr.replaceAll("\\D+", "");
        return numberOnly.isEmpty() ? 0 : Integer.parseInt(numberOnly);
    }
}
