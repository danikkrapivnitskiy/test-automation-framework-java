package browser;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Slf4j(topic = "|Driver common method|")
public class DriverMethods extends DriverSetUp{
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void setupPage(String link, By cookies) {
        driver.get(link);
        if (cookies != null && !driver.findElements(cookies).isEmpty()) {
            driver.findElement(cookies).click();
        }
    }
    public void clickOnElement(By locator) {
        log.info("Click on element " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeys(By locator, CharSequence key) {
        log.info("Send key " + key + " to " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(key);
    }

    public void submitElement(By locator) {
        log.info("Submit element " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).submit();
    }

    public List<WebElement> getListOfElements(By locator) {
        log.info("Get list of elements " + locator);
        return driver.findElements(locator);
    }

    public String getTextOfElement(By locator) {
        log.info("Get text of element " + locator);
        return driver.findElement(locator).getText();
    }

}
