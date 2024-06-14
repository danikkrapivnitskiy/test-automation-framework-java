package ui.mainLogic;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import ui.BaseDriverMethods;
@Slf4j(topic = "|Main page basic steps|")
public class MainPageBasicSteps extends BaseDriverMethods {
    protected final By from = By.xpath("(//input[@aria-autocomplete='list'])[1]");
    protected final By to = By.xpath("(//input[@aria-autocomplete='list'])[2]");
    protected final By tomorrow = By.xpath("//a[@class='inc ico-right pikaday-up btn btn-blue']");
    protected final By time = By.xpath("(//p//input[@autocomplete='off'])[2]");
    protected final By search = By.xpath("(//button[@class='btn btn-orange btn-small btn-shadow w-full '])");
    protected final By acceptCookies = By.id("didomi-notice-agree-button");
    public MainPageBasicSteps chooseTomorrowDate() {
        log.info("Choose tomorrow date");
        clickOnElement(tomorrow);
        return this;
    }

    public MainPageBasicSteps setDepartureTime(String timeStr) {
        log.info("Set departure time {}", timeStr);
        sendKeys(time, timeStr);
        return this;
    }

    public MainPageBasicSteps setDepartureDestination(String departure) {
        log.info("Set departure destination {}", departure);
        sendKeys(from, departure);
        return this;
    }

    public MainPageBasicSteps setArrivalDestination(String arrival) {
        log.info("Set departure arrival {}", arrival);
        sendKeys(to, arrival);
        return this;
    }

    public void submitSearchDestination() {
        submitElement(search);
    }
}
