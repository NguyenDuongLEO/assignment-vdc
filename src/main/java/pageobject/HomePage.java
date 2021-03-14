package pageobject;

import manage.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='q']")
    public WebElement navSearchForm;

    @FindBy(css = "form[id$='nav-search-form']")
    public WebElement navSearchIcon;

    @FindBy(xpath = "//span[contains(text(), 'OpenWeather')]")
    public WebElement headlineInFindPage;

}