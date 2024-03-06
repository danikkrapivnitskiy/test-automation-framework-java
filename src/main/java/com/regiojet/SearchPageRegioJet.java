package com.regiojet;

import main.MethodsSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SearchPageRegioJet implements MethodsSearchPage {

    WebDriver driver;
    LocatorsRegioJet locators = new LocatorsRegioJet();

    public SearchPageRegioJet(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public int takeDirection(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        Assert.assertTrue(elements.size() > 0, "No trips available for the selected route");
        List<LocalTime> localTimes = new ArrayList<>();
        LocalTime minTime = null;

        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            String timeStr = element.getText();
            LocalTime time = LocalTime.parse(timeStr.substring(0, 5));
            WebElement checkAvailable = driver.findElement(By.xpath(locators.selectItem.toString().substring(9) + "[" + (i + 1) + "]"));
            if (checkAvailable.isEnabled()) {
                localTimes.add(time);
            } else localTimes.add(LocalTime.MAX);
        }

        for (LocalTime timeString : localTimes) {
            if (!timeString.equals(LocalTime.MAX) && (minTime == null || timeString.isBefore(minTime))) {
                minTime = timeString;
            }
        }

        int minIndex = localTimes.indexOf(minTime);

        Assert.assertNotNull(minIndex, "No trip found with the shortest duration");

        System.out.println("Departure and arrival time: " +
                driver.findElement(By.xpath(locators.timeDepartureAndArrival.toString().substring(9) + "[" + (minIndex + 1) + "]")).getText());
        System.out.println("Price of direction " +
                driver.findElement(By.xpath(locators.selectItem.toString().substring(9) + "[" + (minIndex + 1) + "]")).getText());

        return minIndex;
    }

    public void selectItem(int index) {
        List<WebElement> elements = driver.findElements(locators.selectItem);
        Assert.assertFalse(elements.isEmpty(), "No trips available for the selected route");
        Assert.assertTrue(index >= 0 && index < elements.size(), "Invalid index: " + index);

        elements.get(index).click();
    }

    public int price() {
        List<WebElement> elements = driver.findElements(locators.selectItem);
        Assert.assertTrue(elements.size() > 0, "No trips available for the selected route");
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

        Assert.assertNotNull(lowestPrice, "No trip found");

        int indexPrice = priceList.indexOf(lowestPrice);

        System.out.println("Departure and arrival time: " +
                driver.findElement(By.xpath(locators.timeDepartureAndArrival.toString().substring(9) + "[" + (indexPrice + 1) + "]")).getText());
        System.out.println("Price of direction " +
                driver.findElement(By.xpath(locators.selectItem.toString().substring(9) + "[" + (indexPrice + 1) + "]")).getText());

        return indexPrice;
    }
}
