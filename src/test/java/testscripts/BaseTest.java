package testscripts;

import data.OpenweathermapData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobject.FindPage;
import pageobject.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static FindPage findPage;
    protected static OpenweathermapData openweathermapData;

    @BeforeMethod
    public void setUpMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.get(openweathermapData.URL);
        driver.manage().window().maximize();
        verifyHomePageWithSearchBoxInTopBar();
    }

    public void verifyHomePageWithSearchBoxInTopBar(){
        Assert.assertEquals(driver.getTitle(), openweathermapData.HOME_PAGE_TITLE);
        Assert.assertEquals(homePage.navSearchForm.getAttribute("placeholder"),
                openweathermapData.SEARCH_BOX_PLACEHOLDER);
        System.out.println("This is the Home Page");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}
