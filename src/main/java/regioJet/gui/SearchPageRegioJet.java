package regioJet.gui;

import browser.BaseDriverMethods;
import interfaces.MethodsSearchPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Slf4j(topic = "|Search page RegioJet|")
public class SearchPageRegioJet extends BaseDriverMethods implements MethodsSearchPage {

    public final By timeDuration = By.xpath("//span[@class='text-13 lg:text-14']");
    private final String selectItemStr = "(//span[@class='text-13 lg:text-14']//../../div[2])";
    private final By selectItem = By.xpath(selectItemStr);
    public final String timeDepartureAndArrivalStr = "(//h2[@class='h3'])";
    public final By timeDepartureAndArrival = By.xpath("(//h2[@class='h3'])");
    private final By soldOut = By.xpath("//div[@class='flex items-center text-13 lg:text-14 flex-wrap text-secondary-redwarn']");
    private final WebDriver driver;
    public SearchPageRegioJet(WebDriver driver) {
        this.driver = driver;
    }

    public int takeDirection(By locator) {
        List<WebElement> elements = getListOfElements(locator);
        log.info("Found {} trip elements", elements.size());
        Assert.assertTrue(!elements.isEmpty(), "No trips available for the selected route");

        Optional<LocalTime> minTime = IntStream.range(0, elements.size())
                .mapToObj(i -> {
                    WebElement element = elements.get(i);
                    String timeStr = element.getText();
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
        List<WebElement> elements = getListOfElements(selectItem);
        log.info("Found {} trip elements", elements.size());
        Assert.assertTrue(!elements.isEmpty(), "No trips available for the selected route");
        Assert.assertTrue(index >= 0 && index < elements.size(), "Invalid index: " + index);

        elements.get(index).click();
        log.info("Selecting trip at index {}", index);
    }

    public int getMinimumPrice() {
        List<WebElement> elements = getListOfElements(selectItem);
        log.info("Found {} trip elements", elements.size());
        Assert.assertTrue(!elements.isEmpty(), "No trips available for the selected route");

        List<Integer> priceList = new ArrayList<>();
        Integer lowestPrice = Integer.MAX_VALUE;

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

    private String getDepartureAndArrivalTime(int index) {
        return getTextOfElement(By.xpath(String.format("%s[%d]", timeDepartureAndArrivalStr, index + 1)));
    }

    private String getPrice(int index) {
        return getTextOfElement(By.xpath(String.format("%s[%d]", selectItemStr, index + 1)));
    }
}
