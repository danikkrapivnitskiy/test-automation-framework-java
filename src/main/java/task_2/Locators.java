package task_2;

import org.openqa.selenium.By;

public class Locators {

    public final By tableAndDeskSystems = By.xpath("(//span[@class='vn__nav__title'])[text() = 'Table & desk systems']");
    public final By standingDesk = By.xpath("(//span[@class='vn__nav__title'])[text() = 'Standing desk']");
    public final By acceptCookies = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public final By desksForHome = By.xpath("(//span[@class='vn__nav__title'])[text() = 'Desks for home']");
    public final By sortingOptionsOpen = By.xpath("//button[@class='plp-pill plp-pill--small plp-trailing-icon' and @aria-label='Show sorting options modal']");
    public final By sortingOptionsClose = By.xpath("//button[@class='plp-pill plp-pill--small plp-trailing-icon plp-drop-down-pill-selected' and @aria-label='Show sorting options modal']");
    public final By sortBySize = By.xpath("//button[@class='plp-pill plp-pill--small plp-trailing-icon' and @aria-label='Show filter modal Size']");
    public final By dropDown = By.xpath("//div[@class='plp-drop-down']");
    public final By radioButtomPriceHighToLow = By.xpath("//span[text()='Price: high to low']/..//input");
    public final By firstExpensiveItem = By.xpath("(//div[@class='pip-product-compact'])[1]");
    public final By secondExpensiveItem = By.xpath("(//div[@class='pip-product-compact'])[2]");
    public final By addFirstItemToShoppingCard = By.xpath("(//button[@class='pip-btn pip-btn--small pip-btn--icon-emphasised pip-product-compact__add-to-cart-button'])[1]");
    public final By addSecondItemToShoppingCard = By.xpath("(//button[@class='pip-btn pip-btn--small pip-btn--icon-emphasised pip-product-compact__add-to-cart-button'])[2]");


}
