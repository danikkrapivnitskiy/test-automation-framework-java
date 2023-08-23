package cz.idos;

import org.openqa.selenium.By;

public class LocatorsIdos {

    public final By from = By.xpath("(//input[@aria-autocomplete='list'])[1]");
    public final By to = By.xpath("(//input[@aria-autocomplete='list'])[2]");
    public final By detailOfTrip = By.xpath("(//li[@class='expand']//a[@class='ext-expand ico-down'])");
    public final By connectionDetails = By.xpath("(//a[@class='ext-expand ico-up']//..//..//..//..//div[@class='connection-details ']//ul[@class='reset stations first last'])");
    public final By timeOfStation = By.xpath("//p[@class='reset time ']");
    public final By nameOfStation = By.xpath("//p[@class='station']");
    public final By price = By.xpath("(//a[@class='ext-expand ico-up']//..//..//..//..//span[@class='price-skipped'])");
    public final By priceErrorMsg = By.xpath("//span[@title = 'Cenu se nepodařilo získat']");
    public final By timeAndDateDeparture = By.xpath("(//h2[@class='reset date'])");
    public final By time = By.xpath("(//p//input[@autocomplete='off'])[2]");
    public final By tomorrow = By.xpath("//a[@class='inc ico-right pikaday-up btn btn-blue']");
    public final By search = By.xpath("(//button[@class='btn btn-orange btn-small btn-shadow w-full '])");
    public final By acceptCookies = By.id("didomi-notice-agree-button");
}
