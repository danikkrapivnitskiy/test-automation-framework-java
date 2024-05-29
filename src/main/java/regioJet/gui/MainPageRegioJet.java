package regioJet.gui;

import browser.BaseDriverMethods;
import interfaces.MethodsMainPage;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public class MainPageRegioJet extends BaseDriverMethods implements MethodsMainPage {

    private final By from = By.xpath("//input[@aria-label='From']");
    private final By to = By.xpath("//input[@aria-label='To']");
    public final By departure = By.xpath("(//div[@class='sm:hidden relative rounded-sm bg-neutral-white']//div[@class='flex items-center gap-1 '])[1]");
    public final By acceptCookies = By.xpath("//button[@class='inline-flex items-center justify-center px-2.5 " +
            "rounded-sm font-bold transition focus:outline-none focus-visible:outline-none focus-visible:shadow-border " +
            "hover:shadow-modal cursor-pointer bg-primary-blue text-white border-none hover:bg-secondary-bluedark " +
            "focus-visible:bg-secondary-bluedark h-12 sm:w-full lg:px-4 sm:order-first']");
    public final By confirm = By.xpath("//div[@class='react-select__option css-1oxt1zm-option'][1]");
    public final By tomorrow = By.xpath("//div[@class='p-3 searchBox-mob-container']/div[1]/button[2]");
    public final By today = By.xpath("//div[@class='p-3 searchBox-mob-container']/div[1]/button[1]");
    public final By search = By.xpath("//button[@class='inline-flex items-center justify-center " +
            "px-2.5 rounded-sm font-bold transition focus:outline-none focus-visible:outline-none focus-visible:shadow-border " +
            "hover:shadow-modal cursor-pointer bg-primary-blue text-white border-none hover:bg-secondary-bluedark " +
            "focus-visible:bg-secondary-bluedark h-12 sm:w-full']");
    private final WebDriver driver;
    private final Calendar calendar = Calendar.getInstance();

    public MainPageRegioJet(WebDriver driver){
        this.driver = driver;
    }

    @SneakyThrows
    @Override
    public void searchDestination(String from, String to) {
        setDepartureDestination(from);
        setArrivalDestination(to);
        chooseDate();
        submitElement(search);
    }

    private void setDepartureDestination(String from) {
        sendKeys(this.from, from);
        sendKeys(this.from, Keys.ENTER);
    }

    private void setArrivalDestination(String to) {
        sendKeys(this.to, to);
        sendKeys(this.to, Keys.ENTER);
    }

    /**
     * Method choose today's day except only for Monday and Friday
     */
    private void chooseDate() {
        clickOnElement(departure);
        calendar.setTime(new Date());
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            clickOnElement(today);
        } else clickOnElement(tomorrow);
    }

    @Override
    public void setupPage(String link) {
        setupPageAndApplyCookies(link, acceptCookies);
    }
}

