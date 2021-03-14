package testscripts.UI;

import data.OpenweathermapData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobject.FindPage;
import pageobject.HomePage;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static FindPage findPage;
    protected static OpenweathermapData openweathermapData;

    public void setUpClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.get(OpenweathermapData.URL);
        driver.manage().window().maximize();
        verifyHomePageWithSearchBoxInTopBar();
    }

    public void verifyHomePageWithSearchBoxInTopBar(){
        Assert.assertEquals(driver.getTitle(), OpenweathermapData.HOME_PAGE_TITLE);
        Assert.assertEquals(homePage.navSearchForm.getAttribute("placeholder"),
                OpenweathermapData.SEARCH_BOX_PLACEHOLDER);
    }

    public void tearDownClass() {
        driver.quit();
    }
}
