package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public abstract class MethodsMainPage {

    WebDriver driver;

    public MethodsMainPage(WebDriver driver){
        this.driver=driver;
    }

    public abstract void searchDestination(String from, String to) throws InterruptedException;
}
