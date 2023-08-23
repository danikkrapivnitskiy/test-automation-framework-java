package browser;

import com.regiojet.LocatorsRegioJet;
import cz.idos.LocatorsIdos;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Browser {

    WebDriver driver ;
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
        driver.close();
    }
}
