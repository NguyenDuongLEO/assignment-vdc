package testscripts.api.featuresApi;

import com.aventstack.extentreports.GherkinKeyword;
import data.OpenweathermapData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import testscripts.ui.BaseTest;

import static util.ApiUtil.*;

public class TestStepsApi extends BaseTest{

    private Response responseBody;
    public Response getResponseBody() { return responseBody;  }
    public void setResponseBody(Response responseBody) {
        this.responseBody = responseBody;
    }

    private int responseCode;
    public int getResponseCode() { return responseCode;  }
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @When("^user wants to get (.*) city weather$")
    public void user_wants_to_get_valid_city_weather(String city) throws Throwable {
        RestAssured.baseURI = OpenweathermapData.URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/data/2.5/find?type=like&sort=population&cnt=30&appid=439d4b804bc8187953eb36d2a8c26a02&q=" + city);
        setResponseBody(response);
        setResponseCode(response.getStatusCode());
    }

    @Then("^the response data is returned$")
    public void the_response_data_is_returned() throws Throwable {
        try{
            if(getResponseCode() == 200) {
                Assert.assertEquals("The search result is matching",
                        getObjectInBody(getResponseBody(), "list", 0, "name"),
                        OpenweathermapData.SEARCH_RESULT_HO_CHI_MINH);
            }
            else {
                System.out.println("HTTP Response Code: " + getResponseCode());
                System.out.println("Response Body: " + getBodyAsJSONObject(getResponseBody()));
                Assert.fail();
            }
        } catch (Exception ex) {}

    }

    @Then("^the response empty data is returned$")
    public void the_response_empty_data_is_returned() throws Throwable {
        try{
            if(getResponseCode() == 400) {
                getBodyAsJSONObject(getResponseBody());
                Assert.assertTrue(true);
            }
            else {
                System.out.println("HTTP Response Code: " + getResponseCode());
                System.out.println("Response Body: " + getBodyAsJSONObject(getResponseBody()));
                Assert.fail();
            }
        } catch (Exception ex) {}
    }



}
