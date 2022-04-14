package task_2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {

    WebDriver driver;
    Locators locators = new Locators();

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTwoExpensiveItems() throws InterruptedException {
        driver.findElement(locators.sortingOptionsOpen).click();
        driver.findElement(locators.radioButtomPriceHighToLow).click();
        driver.findElement(locators.sortingOptionsClose).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement firstItem = driver.findElement(locators.firstExpensiveItem);
        actions.moveToElement(firstItem);
        driver.findElement(locators.addFirstItemToShoppingCard).click();
        WebElement secondItem = driver.findElement(locators.secondExpensiveItem);
        actions.moveToElement(secondItem);
        driver.findElement(locators.addSecondItemToShoppingCard).click();
    }
}
