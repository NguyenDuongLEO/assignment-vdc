package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleElements {
    public static void WaitAndClickElement(WebDriver driver, WebElement element){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void WaitAndSendKey(WebDriver driver, WebElement element, String key){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(key);
    }
}
