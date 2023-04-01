package com.regiojet;

import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchPage {

    WebDriver driver;
    Locators locators = new Locators();

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public int takeDirection(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        Assert.assertTrue("No trips available for the selected route", elements.size() > 0);
        List<LocalTime> localTimes = new ArrayList<>();
        List<WebElement> elements2 = driver.findElements(locators.selectItem);
        LocalTime minTime = null;

        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            WebElement element2 = elements2.get(i);
            String timeStr = element.getText();
            String priceStr = element2.getText();
            LocalTime time = LocalTime.parse(timeStr.substring(0, 5));
            String numberOnly = priceStr.replaceAll("\\D+", "");
            if (numberOnly.isEmpty()) {
                localTimes.add(LocalTime.MAX);
            } else localTimes.add(time);
        }

        for (LocalTime timeString : localTimes) {
            if (!timeString.equals(LocalTime.MAX) && (minTime == null || timeString.isBefore(minTime))) {
                minTime = timeString;
            }
        }

        int minIndex = localTimes.indexOf(minTime);

        Assertions.assertNotNull(minIndex, "No trip found with the shortest duration");

        System.out.println("Departure and arrival time: " +
                driver.findElement(By.xpath(locators.timeDepartureAndArrival.toString().substring(9) + "[" + (minIndex + 1) + "]")).getText());
        System.out.println("Price of direction " +
                driver.findElement(By.xpath(locators.selectItem.toString().substring(9) + "[" + (minIndex + 1) + "]")).getText());

        return minIndex;
    }

    public void selectItem(int i) {
        driver.findElement(By.xpath(locators.selectItem.toString().substring(9) + "[" + (i + 1) + "]")).click();
    }

    public int price(String value) {
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
