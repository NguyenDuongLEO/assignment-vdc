package testscripts.UI.HomePage;

import data.OpenweathermapData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTest;

public class Home_002 extends BaseTest {
    @Test
    public void verifyInputHoChiMinhCityAndClickOnSearchIcon(){
        homePage.navSearchForm.click();
        homePage.navSearchForm.sendKeys("ho chi minh");
        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.cssSelector("form[id$='nav-search-form']"))).build().perform();
        actions.moveToElement(homePage.navSearchIcon).build().perform();
//        verifyNavigatedToFindPage();
        homePage.verifyNavigatedToFindPage(OpenweathermapData.FIND_PAGE_TITLE);
    }

}