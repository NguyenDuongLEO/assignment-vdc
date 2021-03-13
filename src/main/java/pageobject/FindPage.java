package pageobject;

import manage.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FindPage {

    WebDriver driver = DriverFactory.getDriver();

    //===Find Page===
    @FindBy(xpath = "//h2[contains(text(),'Weather in your city')]")
    public WebElement headlineInFindPage;



    public FindPage(WebDriver driver){
        this.driver = driver;
    }
}