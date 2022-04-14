package task_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    public void switchToCategory(By category) {
        driver.findElement(category).click();
    }
}

