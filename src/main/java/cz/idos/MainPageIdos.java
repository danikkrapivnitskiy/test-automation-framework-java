package cz.idos;

import browser.BaseDriverMethods;
import interfaces.MethodsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageIdos extends BaseDriverMethods implements MethodsMainPage {
    private final By from = By.xpath("(//input[@aria-autocomplete='list'])[1]");
    private final By to = By.xpath("(//input[@aria-autocomplete='list'])[2]");
    private final By tomorrow = By.xpath("//a[@class='inc ico-right pikaday-up btn btn-blue']");
    private final By time = By.xpath("(//p//input[@autocomplete='off'])[2]");
    public final By search = By.xpath("(//button[@class='btn btn-orange btn-small btn-shadow w-full '])");
    private final By acceptCookies = By.id("didomi-notice-agree-button");
    private WebDriver driver;

    public MainPageIdos(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void searchDestination(String from, String to) {
        clickOnElement(tomorrow);
        sendKeys(time, "08:00");
        sendKeys(this.from, from);
        sendKeys(this.to, to);
        submitElement(search);
    }

    @Override
    public void setupPage(String link) {
        setupPageAndApplyCookies(link, acceptCookies);
    }
}

