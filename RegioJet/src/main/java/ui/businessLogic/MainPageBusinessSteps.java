package ui.businessLogic;

import interfaces.MethodsMainPage;
import lombok.SneakyThrows;
import ui.mainLogic.MainPageBasicSteps;

import java.util.Calendar;
import java.util.Date;

public class MainPageBusinessSteps extends MainPageBasicSteps implements MethodsMainPage {

    private final Calendar calendar = Calendar.getInstance();

    @SneakyThrows
    @Override
    public void searchDestination(String from, String to) {
        setDepartureDestination(from).setArrivalDestination(to);
        chooseDate();
        clickSearchDestination();
    }

    /**
     * Method choose today's day except only for Monday and Friday
     */
    private void chooseDate() {
        openCalendar();
        calendar.setTime(new Date());
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            clickOnElement(today);
        } else clickOnElement(tomorrow);
    }

    @Override
    public void setupPage(String link) {
        setupPageAndApplyCookies(link, acceptCookies);
    }
}

