package interfaces;

import org.openqa.selenium.By;

public interface MethodsSearchPage {

    int takeDirection(By locator);
    void selectDirection(int index);
    int getMinimumPrice();}
