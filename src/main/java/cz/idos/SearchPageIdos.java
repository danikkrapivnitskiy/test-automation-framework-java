package cz.idos;

import browser.DriverMethods;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
@Slf4j(topic = "|Search page Idos|")
public class SearchPageIdos{
    private final By detailOfTrip = By.xpath("(//li[@class='expand']//a[@class='ext-expand ico-down'])");
    private final String connectionDetails = "(//a[@class='ext-expand ico-up']//..//..//..//..//div[@class='connection-details ']//ul[@class='reset stations first last'])";
    private final String timeOfStation = "//p[@class='reset time ']";
    private final String nameOfStation = "//p[@class='station']";
    private final By price = By.xpath("(//a[@class='ext-expand ico-up']//..//..//..//..//span[@class='price-skipped'])");
    private final By priceErrorMsg = By.xpath("//span[@title = 'Cenu se nepodařilo získat']");
    private final By timeAndDateDeparture = By.xpath("(//h2[@class='reset date'])");
    WebDriver driver;
    private final DriverMethods driverMethods = new DriverMethods();

    public SearchPageIdos(WebDriver driver) {
        this.driver = driver;
    }

    public void getInformationOfTrip(Boolean logging) {
        List<WebElement> elementsDetails = driverMethods.getListOfElements(detailOfTrip);
        Assertions.assertTrue(elementsDetails.size() > 0, "No trips available for the selected route ");
        for (int count = 0; count < elementsDetails.size(); count++) {
            elementsDetails.get(count).click();
            List<WebElement> priceError = driverMethods.getListOfElements(priceErrorMsg);
            Assertions.assertFalse(priceError.size() != 0, "Price is not available");
            if (logging) {
                logTripDetails(count);
            }
        }
    }

    private void logTripDetails(int count) {
        List<WebElement> time = getTimeElements(count);
        List<WebElement> name = getNameElements(count);

        LocalTime timeDeparture = LocalTime.parse(time.get(0).getText(), DateTimeFormatter.ofPattern("H:mm"));
        LocalTime timeArrival = LocalTime.parse(time.get(time.size() - 1).getText(), DateTimeFormatter.ofPattern("H:mm"));

        log.info("Direction {}", (count + 1));
        log.info("Number of stop is: {}", time.size());

        for (int i = 0; i < time.size(); i++) {
            String timeStrDeparture = time.get(i).getText();
            log.info("{}: Time of station {} is {}", i + 1, name.get(i).getText(), timeStrDeparture);
        }

        Duration duration = Duration.between(timeDeparture, timeArrival);
        log.info("Time of travel: {} hours {} minutes", duration.toHours(), duration.toMinutesPart());

        log.info("Price is: {}", driver.findElements(price).get(count).getText());
    }

    private List<WebElement> getTimeElements(int count) {
        String timeStr = String.format(connectionDetails + "[%d]/li" + timeOfStation, count + 1);
        return driverMethods.getListOfElements(By.xpath(timeStr));
    }

    private List<WebElement> getNameElements(int count) {
        String nameStr = String.format(connectionDetails + "[%d]/li" + nameOfStation, count + 1);
        return driverMethods.getListOfElements(By.xpath(nameStr));
    }

    public void verifyDateAndTimeDeparture(int hour, int minute) {
        List<WebElement> elementsDate = driverMethods.getListOfElements(timeAndDateDeparture);
        Assertions.assertTrue(elementsDate.size() > 0, "No trips available for the selected route ");

        LocalTime settingTime = LocalTime.of(hour, minute);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate currentDate = LocalDate.now();

        for (WebElement element : elementsDate) {
            verifyDateAndTimeForElement(element, settingTime, tomorrow, currentDate);
        }
    }

    private void verifyDateAndTimeForElement(WebElement element, LocalTime settingTime, LocalDate tomorrow, LocalDate currentDate) {
        String dateAndTime = element.getText();
        LocalTime time = LocalTime.parse(dateAndTime.substring(0, 4), DateTimeFormatter.ofPattern("H:mm"));
        Assertions.assertTrue(time.equals(settingTime) || time.isAfter(settingTime), "Time is earlier than " + settingTime);

        int year = getYear(currentDate);
        LocalDate date = parseDate(dateAndTime, year);

        Assertions.assertTrue(date.isEqual(tomorrow), "Date is not tomorrow ");
    }

    private int getYear(LocalDate currentDate) {
        return currentDate.isEqual(currentDate.with(TemporalAdjusters.lastDayOfYear()))
                ? currentDate.getYear() + 1
                : currentDate.getYear();
    }

    private LocalDate parseDate(String dateAndTime, int year) {
        return LocalDate.parse(dateAndTime.substring(4, 8) + (dateAndTime.charAt(8) == '.' ? "." + year : year),
                DateTimeFormatter.ofPattern("d.M.yyyy"));
    }
}
