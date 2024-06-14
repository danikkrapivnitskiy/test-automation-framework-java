package ui.businessLogic;

import interfaces.MethodsMainPage;
import ui.mainLogic.MainPageBasicSteps;

public class MainPageBusinessSteps extends MainPageBasicSteps implements MethodsMainPage {

    @Override
    public void searchDestination(String from, String to) {
        chooseTomorrowDate()
                .setDepartureTime("08:00")
                .setDepartureDestination(from)
                .setArrivalDestination(to)
                .submitSearchDestination();
    }

    @Override
    public void setupPage(String link) {
        setupPageAndApplyCookies(link, acceptCookies);
    }
}

