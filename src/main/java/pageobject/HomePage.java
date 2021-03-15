package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    final WebDriver driver;
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