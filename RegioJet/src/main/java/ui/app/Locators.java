package ui.app;

import org.openqa.selenium.By;
import ui.BaseDriverMethods;

public class Locators extends BaseDriverMethods {
    protected final By from = By.xpath("//input[@aria-label='From']");
    protected final By to = By.xpath("//input[@aria-label='To']");
    protected final By departure = By.xpath("(//div[@class='sm:hidden relative rounded-sm bg-neutral-white']//div[@class='flex items-center gap-1 '])[1]");
    protected final By acceptCookies = By.xpath("(//div[@class='flex sm:flex-col gap-2 justify-end']/button)[2]");
    protected final By tomorrow = By.xpath("//div[@class='p-3 searchBox-mob-container']/div[1]/button[2]");
    protected final By today = By.xpath("//div[@class='p-3 searchBox-mob-container']/div[1]/button[1]");
    protected final By search = By.cssSelector(".inline-flex.text-white");
    public final By timeDuration = By.xpath("//span[@class='text-13 lg:text-14']");
    protected final String selectItemStr = "(//span[@class='text-13 lg:text-14']//../../div[2])";
    protected final By selectItem = By.xpath(selectItemStr);
    protected final String timeDepartureAndArrivalStr = "(//h2[@class='h3'])";
    public final By timeDepartureAndArrival = By.xpath("(//h2[@class='h3'])");

}
