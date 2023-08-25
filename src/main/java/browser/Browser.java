package browser;

import com.regiojet.LocatorsRegioJet;
import cz.idos.LocatorsIdos;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Browser {

    WebDriver driver ;

    Date dateNow = new Date();
    SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");

    String fileName = "screenshot_" + format.format(dateNow) + ".png";
    LocatorsRegioJet locatorsRegioJet = new LocatorsRegioJet();
    LocatorsIdos locatorsIdos = new LocatorsIdos();

    public Browser(WebDriver driver){
        this.driver=driver;
    }

    public void setUpPage(String link) {
        driver.get(link);
        try {
            WebElement regioJetCookiesButton = driver.findElement(locatorsRegioJet.acceptCookies);
            if (regioJetCookiesButton.isDisplayed()) {
                regioJetCookiesButton.click();
            }
        } catch (NoSuchElementException e) {
            try {
                WebElement idosCookiesButton = driver.findElement(locatorsIdos.acceptCookies);
                if (idosCookiesButton.isDisplayed()) {
                    idosCookiesButton.click();
                }
            } catch (NoSuchElementException ex) {

            }
        }
    }

    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("screenshots\\" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.close();
    }
}
