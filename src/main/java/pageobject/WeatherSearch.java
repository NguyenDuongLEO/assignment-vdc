package pageobject;

import manage.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeatherSearch {

    WebDriver driver = DriverFactory.getDriver();

    //===Title Web Element===
    @FindBy(xpath = "//*[@id='q']")
    public WebElement weatherSearchBox;

    public WeatherSearch(WebDriver driver){
        this.driver = driver;
    }
}