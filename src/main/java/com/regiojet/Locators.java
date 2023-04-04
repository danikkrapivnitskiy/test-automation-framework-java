package com.regiojet;

import org.openqa.selenium.By;

public class Locators {

    public final By from = By.xpath("//input[@aria-label='From']");
    public final By to = By.xpath("//input[@aria-label='To']");
    public final By confirm = By.xpath("//div[@class='react-select__option css-1oxt1zm-option'][1]");
    public final By tomorrow = By.xpath("(//div[@class='inline-block p-3 searchBox-mob-container']//button)[2]");
    public final By today = By.xpath("(//div[@class='inline-block p-3 searchBox-mob-container']//button)[1]");
    public final By search = By.xpath("//button[@class='inline-flex items-center justify-center " +
            "px-2.5 rounded-sm font-bold transition focus:outline-none focus-visible:outline-none focus-visible:shadow-border " +
            "hover:shadow-modal cursor-pointer bg-primary-blue text-white border-none hover:bg-secondary-bluedark " +
            "focus-visible:bg-secondary-bluedark h-12 sm:w-full']");
    public final By departure = By.xpath("//div[@class='flex items-center gap-1']");
    public final By acceptCookies = By.xpath("//button[@class='inline-flex items-center justify-center px-2.5 " +
            "rounded-sm font-bold transition focus:outline-none focus-visible:outline-none focus-visible:shadow-border " +
            "hover:shadow-modal cursor-pointer bg-primary-blue text-white border-none hover:bg-secondary-bluedark " +
            "focus-visible:bg-secondary-bluedark h-12 sm:w-full lg:px-4 sm:order-first']");
    public final By timeDuration = By.xpath("//span[@class='text-13 lg:text-14']");
    public final By selectItem = By.xpath("(//span[@class='text-13 lg:text-14']//../../div[2])");
    public final By timeDepartureAndArrival = By.xpath("(//h2[@class='h3'])");
    public final By soldOut = By.xpath("//div[@class='flex items-center text-13 lg:text-14 flex-wrap text-secondary-redwarn']");
    public final By mondayDeparture = By.xpath("(//td[@class='CalendarDay CalendarDay_1 CalendarDay__default " +
            "CalendarDay__default_2 CalendarDay__firstDayOfWeek CalendarDay__firstDayOfWeek_3'])[1]");

}
