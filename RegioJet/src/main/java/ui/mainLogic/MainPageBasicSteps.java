package ui.mainLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ui.BaseDriverMethods;

public class MainPageBasicSteps extends BaseDriverMethods {
    protected final By from = By.xpath("//input[@aria-label='From']");
    protected final By to = By.xpath("//input[@aria-label='To']");
    protected final By departure = By.xpath("(//div[@class='sm:hidden relative rounded-sm bg-neutral-white']//div[@class='flex items-center gap-1 '])[1]");
    protected final By acceptCookies = By.xpath("(//div[@class='flex sm:flex-col gap-2 justify-end']/button)[2]");
    protected final By tomorrow = By.xpath("//div[@class='p-3 searchBox-mob-container']/div[1]/button[2]");
    protected final By today = By.xpath("//div[@class='p-3 searchBox-mob-container']/div[1]/button[1]");
    protected final By search = By.cssSelector(".inline-flex.text-white");
    public MainPageBasicSteps setDepartureDestination(String fromStr) {
        sendKeys(from, fromStr);
        sendKeys(from, Keys.ENTER);
        return this;
    }
    public void setArrivalDestination(String toStr) {
        sendKeys(to, toStr);
        sendKeys(to, Keys.ENTER);
    }
    public void openCalendar() {
        clickOnElement(departure);
    }
    public void clickSearchDestination() {
        submitElement(search);
    }
}
