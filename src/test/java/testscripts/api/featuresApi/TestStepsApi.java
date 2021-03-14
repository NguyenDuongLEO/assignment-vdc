package testscripts.api.featuresApi;

import data.OpenweathermapData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.FindPage;
import pageobject.HomePage;
import testscripts.ui.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static util.ApiUtil.getDataFromJson;

public class TestStepsApi extends BaseTest{

    @When("^user wants to get (.*) city weather$")
    public void user_wants_to_get_valid_city_weather(String city) throws Throwable {
        RestAssured.baseURI = OpenweathermapData.URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/data/2.5/find?type=like&sort=population&cnt=30&appid=439d4b804bc8187953eb36d2a8c26a02&q=" + city);
        ResponseBody body = response.getBody();
        List list = body.jsonPath().getList("list");
        System.out.println("Print: " + list);
    }


    @Then("^the response data is returned$")
    public void find_page_is_displayed_with_correct_page_title() throws Throwable {
//        AssertEqualsCustomize(driver.getTitle(), OpenweathermapData.FIND_PAGE_TITLE);
    }

}
