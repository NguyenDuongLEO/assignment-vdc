package testscripts.UI.features;

import data.OpenweathermapData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageobject.FindPage;
import pageobject.HomePage;
import testscripts.UI.BaseTest;
import java.util.concurrent.TimeUnit;
import static util.HandleElements.WaitAndSendKey;

public class TestSteps extends BaseTest {
    @Before
    public void setUpClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
        findPage = PageFactory.initElements(driver, FindPage.class);
        driver.get(OpenweathermapData.URL);
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
    public void user_is_on_homepage() throws Throwable {

    }

    @When("^user enters (.*) city in the navigation search box$")
    public void user_enters_valid_city_in_the_navigation_search_box(String city) throws Throwable {
        WaitAndSendKey(driver, homePage.navSearchForm, city);
        setCity(city);
    }

    @And("^user selects enter on keyboard to search$")
    public void user_selects_enter_on_keyboard_to_search() throws Throwable {
        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.navSearchForm).sendKeys(Keys.ENTER).build().perform();
    }

    @Then("^find page is displayed with correct page title$")
    public void find_page_is_displayed() throws Throwable {
        Assert.assertEquals(driver.getTitle(), OpenweathermapData.FIND_PAGE_TITLE);
    }

    @And("^find page header as Weather in your city is displayed$")
    public void find_page_header_is_displayed() throws Throwable {
        Assert.assertEquals(findPage.headlineInFindPage.getText(), OpenweathermapData.HEADLINE_WEATHER_IN_YOUR_CITY);
    }

    @And("^search form is displayed with the previous city entered$")
    public void search_form_is_displayed_with_previous_city_entered() throws Throwable {
        Assert.assertEquals(findPage.searchboxInForm.getAttribute("value"), getCity());
        Assert.assertEquals(findPage.searchButtonInForm.getText(), OpenweathermapData.SEARCH_BUTTON_TEXT);
    }

}
