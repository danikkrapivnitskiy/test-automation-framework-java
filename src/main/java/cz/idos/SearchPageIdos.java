package cz.idos;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class SearchPageIdos{

    WebDriver driver;
    LocatorsIdos locators = new LocatorsIdos();

    public SearchPageIdos(WebDriver driver) {
        this.driver = driver;
    }

    public void informationOfTrip() {
        List<WebElement> elementsDetails = driver.findElements(locators.detailOfTrip);
        Assert.assertTrue("No trips available for the selected route ", elementsDetails.size() > 0);
        for (int count = 0; count < elementsDetails.size(); count++) {
            elementsDetails.get(count).click();
            List<WebElement> priceError = driver.findElements(locators.priceErrorMsg);
            Assert.assertFalse("Price is not available", priceError.size() != 0);
            List<WebElement> time = driver.findElements(By.xpath(locators.connectionDetails.toString().substring(9) + "[" + (count + 1) + "]" + "/li"
                    + locators.timeOfStation.toString().substring(9)));
            LocalTime timeDeparture = LocalTime.parse(time.get(0).getText(), DateTimeFormatter.ofPattern("H:mm"));
            LocalTime timeArrival= LocalTime.parse(time.get(time.size() - 1).getText(), DateTimeFormatter.ofPattern("H:mm"));

            List<WebElement> name = driver.findElements(By.xpath(locators.connectionDetails.toString().substring(9) + "[" + (count + 1) + "]" + "/li"
                    + locators.nameOfStation.toString().substring(9)));

            System.out.println("Direction " + (count + 1));
            System.out.println("Number of stop is: " + time.size());
            for (int i = 0; i < time.size(); i++) {
                String timeStrDeparture = time.get(i).getText();
                System.out.println((i + 1) + ": Time of station " + name.get(i).getText() + " is " + timeStrDeparture);
            }

            Duration duration = Duration.between(timeDeparture, timeArrival);
            System.out.println("Time of travel : " + duration.toHours() + " hours " + duration.toMinutesPart() + " minutes ");

            System.out.println("Price is : " + driver.findElements(locators.price).get(count).getText());
        }
    }

    public void verifyDateAndTime() {
        List<WebElement> elementsDate = driver.findElements(locators.timeAndDateDeparture);
        LocalTime eightAM = LocalTime.of(8, 0);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate currentDate = LocalDate.now();
        int year;
        Assert.assertTrue("No trips available for the selected route ", elementsDate.size() > 0);
        for (int i = 0; i < elementsDate.size(); i++) {
            WebElement element = elementsDate.get(i);
            String dateAndTime = element.getText();
            LocalTime time = LocalTime.parse(dateAndTime.substring(0,4), DateTimeFormatter.ofPattern("H:mm"));
            Assert.assertTrue("Time is earlier than 8AM ", time.equals(eightAM) || time.isAfter(eightAM));
            if (currentDate.isEqual(currentDate.with(TemporalAdjusters.lastDayOfYear()))) {
                year = currentDate.getYear() + 1;
            } else {
                year = currentDate.getYear();

            }

            LocalDate date = LocalDate.parse(dateAndTime.substring(4, 8) + "." + year, DateTimeFormatter.ofPattern("d.M.yyyy"));

            Assert.assertTrue("Date is not tomorrow ", date.isEqual(tomorrow));
        }
    }
}
