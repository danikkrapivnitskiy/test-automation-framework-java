package ui.mainLogic;

import org.openqa.selenium.By;

public class BookPageBasicSteps extends BasePageBasicSteps {
    protected final By author = By.xpath("//div[@class='work-title-and-author desktop']//a[@itemprop='author']");
}
