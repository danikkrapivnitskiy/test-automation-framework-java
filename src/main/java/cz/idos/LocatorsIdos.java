package cz.idos;

import org.openqa.selenium.By;

public class LocatorsIdos {

    public final By from = By.xpath("(//input[@aria-autocomplete='list'])[1]");
    public final By to = By.xpath("(//input[@aria-autocomplete='list'])[2]");
    public final By detailOfTrip = By.xpath("(//li[@class='expand']//a[@class='ext-expand ico-down'])");
    public final By dateDeparture = By.xpath("(//li[@class='expand']/../../..//span[@class='date-after'])");
    public final By timeAndDateDeparture = By.xpath("(//h2[@class='reset date'])");
    public final By time = By.xpath("(//p//input[@autocomplete='off'])[2]");
    public final By confirm = By.xpath("//div[@class='react-select__option css-1oxt1zm-option'][1]");
    public final By tomorrow = By.xpath("//a[@class='inc ico-right pikaday-up btn btn-blue']");
    public final By today = By.xpath("(//div[@class='inline-block p-3 searchBox-mob-container']//button)[1]");
    public final By search = By.xpath("(//button[@class='btn btn-orange btn-small btn-shadow w-full '])");
    public final By departure = By.xpath("//div[@class='flex items-center gap-1']");
    public final By acceptCookies = By.id("didomi-notice-agree-button");
    public final By timeDuration = By.xpath("//span[@class='text-13 lg:text-14']");
    public final By selectItem = By.xpath("(//span[@class='text-13 lg:text-14']//../../div[2])");
    public final By timeDepartureAndArrival = By.xpath("(//h2[@class='h3'])");
    public final By soldOut = By.xpath("//div[@class='flex items-center text-13 lg:text-14 flex-wrap text-secondary-redwarn']");
    public final By mondayDeparture = By.xpath("(//td[@class='CalendarDay CalendarDay_1 CalendarDay__default " +
            "CalendarDay__default_2 CalendarDay__firstDayOfWeek CalendarDay__firstDayOfWeek_3'])[1]");

}
