package ui.app;

import org.openqa.selenium.By;
import ui.BaseDriverMethods;

public class Locators extends BaseDriverMethods {
    protected final By from = By.xpath("(//input[@aria-autocomplete='list'])[1]");
    protected final By to = By.xpath("(//input[@aria-autocomplete='list'])[2]");
    protected final By tomorrow = By.xpath("//a[@class='inc ico-right pikaday-up btn btn-blue']");
    protected final By time = By.xpath("(//p//input[@autocomplete='off'])[2]");
    protected final By search = By.xpath("(//button[@class='btn btn-orange btn-small btn-shadow w-full '])");
    protected final By acceptCookies = By.id("didomi-notice-agree-button");
    protected final By detailOfTrip = By.xpath("(//li[@class='expand']//a[@class='ext-expand ico-down'])");
    // Selector for training
    protected final String connectionDetails = "(//a[@class='ext-expand ico-up']" +
            "//ancestor::div[@class='connection-head']/following-sibling::div[@class='connection-details ']" +
            "//ul[@class='reset stations first last'])";
    protected final String timeOfStation = "//p[@class='reset time ']";
    protected final String nameOfStation = "//p[@class='station']";
    // Selector for training
    protected final By price = By.xpath("(//a[@class='ext-expand ico-up']" +
            "//ancestor::div[@class='connection-head']/following-sibling::div[@class='connection-expand']" +
            "//child::span[@class='price-skipped'])");
    protected final By priceErrorMsg = By.xpath("//span[@title = 'Cenu se nepodařilo získat']");
    protected final By timeAndDateDeparture = By.xpath("(//h2[@class='reset date'])");
}
