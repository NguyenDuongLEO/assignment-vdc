package util;

import data.OpenweathermapData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobject.HomePage;

public class HandleElements {
    private static HomePage homePage;
    public static void WaitAndClickElement(WebDriver driver, WebElement element){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void WaitAndSendKey(WebDriver driver, WebElement element, String key){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(key);
    }

    public static void verifyNavigationContainSearchBox(){
    Assert.assertEquals(homePage.navSearchForm.getAttribute("placeholder"),
            OpenweathermapData.SEARCH_BOX_PLACEHOLDER);
}
}
