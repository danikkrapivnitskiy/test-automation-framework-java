package cz.idos;

import main.MethodsSearchPage;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SearchPageIdos{

    WebDriver driver;
    LocatorsIdos locators = new LocatorsIdos();

    public SearchPageIdos(WebDriver driver) {
        this.driver = driver;
    }

    public int informationOfTrip() {
//        List<WebElement> elements = driver.findElements(locator);
//        Assert.assertTrue("No trips available for the selected route", elements.size() > 0);
//        List<LocalTime> localTimes = new ArrayList<>();
//        LocalTime minTime = null;
//
//        for (int i = 0; i < elements.size(); i++) {
//            WebElement element = elements.get(i);
//            String timeStr = element.getText();
//            LocalTime time = LocalTime.parse(timeStr.substring(0, 5));
//            WebElement checkAvailable = driver.findElement(By.xpath(locators.selectItem.toString().substring(9) + "[" + (i + 1) + "]"));
//            if (checkAvailable.isEnabled()) {
//                localTimes.add(time);
//            } else localTimes.add(LocalTime.MAX);
//        }
//
//        for (LocalTime timeString : localTimes) {
//            if (!timeString.equals(LocalTime.MAX) && (minTime == null || timeString.isBefore(minTime))) {
//                minTime = timeString;
//            }
//        }
//
//        int minIndex = localTimes.indexOf(minTime);
//
//        Assertions.assertNotNull(minIndex, "No trip found with the shortest duration");
//
//        System.out.println("Departure and arrival time: " +
//                driver.findElement(By.xpath(locators.timeDepartureAndArrival.toString().substring(9) + "[" + (minIndex + 1) + "]")).getText());
//        System.out.println("Price of direction " +
//                driver.findElement(By.xpath(locators.selectItem.toString().substring(9) + "[" + (minIndex + 1) + "]")).getText());
//
//        return minIndex;

        List<WebElement> elementsDetails = driver.findElements(locators.detailOfTrip);
        Assert.assertTrue("No trips available for the selected route ", elementsDetails.size() > 0);
        int count;
        for (count = 0; count < elementsDetails.size(); count++) {
            elementsDetails.get(count).click();
        }
        return count;
    }

    public void verifyDateAndTime() {
        List<WebElement> elementsDate = driver.findElements(locators.timeAndDateDeparture);
        LocalTime eightAM = LocalTime.of(8, 0);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Assert.assertTrue("No trips available for the selected route ", elementsDate.size() > 0);
        for (int i = 0; i < elementsDate.size(); i++) {
            WebElement element = elementsDate.get(i);
            String dateAndTime = element.getText();
            LocalTime time = LocalTime.parse(dateAndTime.substring(0, 4), DateTimeFormatter.ofPattern("hh:mm"));
            Assert.assertTrue("Time is earlier than 8AM ", time.equals(eightAM) || time.isAfter(eightAM));
            LocalDate date = LocalDate.parse(dateAndTime.substring(5, 8), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Assert.assertTrue("Date is not tomorrow ", date.isEqual(tomorrow));
        }
    }

    public void selectItem(int index) {
        List<WebElement> elements = driver.findElements(locators.selectItem);
        Assert.assertFalse("No trips available for the selected route", elements.isEmpty());
        Assert.assertTrue("Invalid index: " + index, index >= 0 && index < elements.size());

        elements.get(index).click();
    }

    public int price() {
        List<WebElement> elements = driver.findElements(locators.selectItem);
        Assert.assertTrue("No trips available for the selected route", elements.size() > 0);
        List<Integer> priceList = new ArrayList<>();
        Integer lowestPrice = Integer.MAX_VALUE;

        for (WebElement element : elements) {
            String priceStr = element.getText();
            String numberOnly = priceStr.replaceAll("\\D+", "");
            if (numberOnly.isEmpty()) {
                priceList.add(0);
            } else {
                int valueOfNumber = Integer.parseInt(numberOnly);
                priceList.add(valueOfNumber);
            }
        }

        for (int i : priceList) {
            if (i != 0 && i < lowestPrice) {
                lowestPrice = i;
            }
        }

        Assertions.assertNotNull(lowestPrice, "No trip found");

        int indexPrice = priceList.indexOf(lowestPrice);

        System.out.println("Departure and arrival time: " +
                driver.findElement(By.xpath(locators.timeDepartureAndArrival.toString().substring(9) + "[" + (indexPrice + 1) + "]")).getText());
        System.out.println("Price of direction " +
                driver.findElement(By.xpath(locators.selectItem.toString().substring(9) + "[" + (indexPrice + 1) + "]")).getText());

        return indexPrice;
    }
}
