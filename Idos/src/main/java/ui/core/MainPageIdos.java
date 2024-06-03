package ui.core;

import ui.app.Actions;
import interfaces.MethodsMainPage;

public class MainPageIdos extends Actions implements MethodsMainPage {

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

