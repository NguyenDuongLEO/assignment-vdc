package scripts.ui.features;

import data.OpenWeatherMapData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import pageobject.FindPage;
import pageobject.HomePage;
import scripts.ui.BaseTest;
import java.util.concurrent.TimeUnit;
import static util.HandleElements.WaitAndSendKey;

public class TestSteps extends BaseTest {
    @Before
    public void setUpClass(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
        findPage = PageFactory.initElements(driver, FindPage.class);
        driver.get(OpenWeatherMapData.URL);
        driver.manage().window().maximize();
    }

    @After
    public void tearDownClass() {
        driver.quit();
    }

    private String city;
    public String getCity() {
        return city;
    }

    public void setCity(String newCity) {
        this.city = newCity;
    }

    @Given("^user is on homepage$")
    public void user_is_on_homepage(){
        Assert.assertEquals("Page Title is matching", OpenWeatherMapData.HOME_PAGE_TITLE, driver.getTitle());
    }

    @When("^user enters (.*) city in the navigation search box$")
    public void user_enters_valid_city_in_the_navigation_search_box(String city){
        WaitAndSendKey(driver, homePage.navSearchForm, city);
        setCity(city);
    }

    @And("^user selects enter on keyboard to search$")
    public void user_selects_enter_on_keyboard_to_search(){
        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.navSearchForm).sendKeys(Keys.ENTER).build().perform();
    }

    @Then("^find page is displayed with correct page title$")
    public void find_page_is_displayed_with_correct_page_title(){
        Assert.assertEquals("Page Title is matching", OpenWeatherMapData.FIND_PAGE_TITLE, driver.getTitle());
    }

    @And("^find page header as Weather in your city is displayed$")
    public void find_page_header_is_displayed() {
        Assert.assertEquals("Headline is matching", OpenWeatherMapData.HEADLINE_WEATHER_IN_YOUR_CITY, findPage.headlineInFindPage.getText());
    }

    @And("^search form is displayed with the previous city entered$")
    public void search_form_is_displayed_with_previous_city_entered(){
        Assert.assertEquals("City is matching", getCity(), findPage.searchBoxInForm.getAttribute("value"));
        Assert.assertEquals("Search button is matching", OpenWeatherMapData.SEARCH_BUTTON_TEXT, findPage.searchButtonInForm.getText());
    }

    @And("^forecast list is displayed$")
    public void forecast_list_is_displayed(){
        Assert.assertNotNull(findPage.forecastList);
    }

    @And("^forecast list is NOT displayed$")
    public void forecast_list_is_not_displayed(){
        if(driver.findElements(By.xpath("//*[@id='forecast_list_ul']//a")).isEmpty()){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }
}
