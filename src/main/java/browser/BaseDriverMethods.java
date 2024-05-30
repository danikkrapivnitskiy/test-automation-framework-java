package browser;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Slf4j(topic = "|Page with common methods|")
public class BaseDriverMethods extends WebDriverFactory{
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    protected void setupPageAndApplyCookies(String link, By cookies) {
        log.info("Navigate to page " + link);
        driver.get(link);
        if (cookies != null && !getListOfElements(cookies).isEmpty()) {
            clickOnElement(cookies);
        }
    }
    protected void clickOnElement(By locator) {
        log.info("Click on element " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, CharSequence key) {
        log.info("Send key " + key + " to " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(key);
    }

    protected void submitElement(By locator) {
        log.info("Submit element " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).submit();
    }

    protected List<WebElement> getListOfElements(By locator) {
        log.info("Get list of elements " + locator);
        return driver.findElements(locator);
    }

    protected String getTextOfElement(By locator) {
        log.info("Get text of element " + locator);
        return driver.findElement(locator).getText();
    }

}
