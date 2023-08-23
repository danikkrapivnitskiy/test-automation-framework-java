package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class MethodsSearchPage {
    WebDriver driver;

    public MethodsSearchPage(WebDriver driver){
        this.driver=driver;
    }

    public abstract int takeDirection(By locator);}
