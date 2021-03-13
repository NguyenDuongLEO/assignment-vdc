package pageobject;

import manage.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

    WebDriver driver = DriverFactory.getDriver();

    //===Navigation Search Form===
    @FindBy(xpath = "//*[@id='q']")
    public WebElement navSearchForm;
    @FindBy(css = "form[id$='nav-search-form']")
    public WebElement navSearchIcon;

    public void verifyNavigatedToFindPage(String FindPageTitle){
        Assert.assertEquals(driver.getTitle(), FindPageTitle);
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
}