package testscripts;

import data.OpenweathermapData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobject.WeatherSearch;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static WeatherSearch weatherSearch;
    protected static OpenweathermapData openweathermapData;

    @BeforeMethod
    public void setUpMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        weatherSearch = PageFactory.initElements(driver, WeatherSearch.class);
        driver.get(openweathermapData.URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}
