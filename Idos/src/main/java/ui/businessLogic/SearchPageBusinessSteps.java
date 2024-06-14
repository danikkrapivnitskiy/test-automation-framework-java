package ui.businessLogic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import ui.mainLogic.SearchPageBasicSteps;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
@Slf4j(topic = "|Search page business steps|")
public class SearchPageBusinessSteps extends SearchPageBasicSteps {

    public void getInformationOfTrip() {
        Assertions.assertTrue(getTripDetails().size() > 0, "No trips available for the selected route ");
        for (int count = 0; count < getTripDetails().size(); count++) {
            getTripDetails().get(count).click();
            Assertions.assertFalse(getListOfElements(priceErrorMsg).size() != 0, "Price is not available");
            logTripDetails(count);
        }
    }

    private void logTripDetails(int count) {
        List<WebElement> time = getListStationTime(count);
        List<WebElement> name = getListStationName(count);

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
        log.info("Price is: {}", getPrice(count));
    }

    public void verifyDateAndTimeDeparture(int hour, int minute) {
        Assertions.assertTrue(getListOfDepartureAndArrivalTime().size() > 0, "No trips available for the selected route ");
        LocalTime settingTime = LocalTime.of(hour, minute);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate currentDate = LocalDate.now();

        for (WebElement element : getListOfDepartureAndArrivalTime()) {
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
