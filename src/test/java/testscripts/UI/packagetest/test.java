package testscripts.UI.packagetest;

import data.OpenweathermapData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pageobject.HomePage;

import static util.HandleElements.WaitAndClickElement;
import static util.HandleElements.WaitAndSendKey;

public class test{
    HomePage homePage;
    public static WebDriver driver;
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(OpenweathermapData.URL);
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @When("^user enters (.*) city$")
    public void user_enters_valid_city(String city) throws Throwable {
        WaitAndSendKey(driver, homePage.navSearchForm, city);
    }

    @And("^user clicks search$")
    public void user_clicks_search() throws Throwable {
        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.navSearchIcon).sendKeys(Keys.ENTER).build().perform();
    }

    @Then("^find page is displayed$")
    public void find_page_is_displayed() throws Throwable {
        homePage.verifyNavigatedToFindPage(OpenweathermapData.FIND_PAGE_TITLE);
    }
}
