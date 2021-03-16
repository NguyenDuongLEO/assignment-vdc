package scripts.api.featuresApi;

import data.OpenWeatherMapData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import scripts.ui.BaseTest;
import static util.ApiUtil.*;

public class TestStepsApi extends BaseTest{

    private Response responseBody;
    public Response getResponseBody() { return responseBody;  }
    public void setResponseBody(Response responseBody) {
        this.responseBody = responseBody;
    }

    private int responseCode;
    public int getResponseCode() { return responseCode; }
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @Given("^API data already setup$")
    public void api_data_already_setup(){
    }

    @When("^user calls APIs with search keyword \"(.*)\"$")
    public void user_wants_to_get_valid_city_weather(String city){
        RestAssured.baseURI = OpenWeatherMapData.URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(OpenWeatherMapData.CONTEXT +
                OpenWeatherMapData.API_VERSION +
                OpenWeatherMapData.API_PATH +
                OpenWeatherMapData.API_TYPE +
                OpenWeatherMapData.API_SORT +
                OpenWeatherMapData.API_CNT +
                OpenWeatherMapData.API_APPID +
                OpenWeatherMapData.API_Q +
                city);
        setResponseBody(response);
        setResponseCode(response.getStatusCode());
    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be_returned(int statusCode) {
        if (statusCode == 200 && getResponseCode() == 200) {
            Assert.assertTrue(true);
        } else if (statusCode == 400 && getResponseCode() == 400) {
            System.out.println("HTTP Response Code: " + getResponseCode());
            System.out.println("Response Body: " + getBodyAsJSONObject(getResponseBody()));
            Assert.fail();
        } else if (statusCode == 500 && getResponseCode() == 500) {
            System.out.println("HTTP Response Code: " + getResponseCode());
            System.out.println("Response Body: " + getBodyAsJSONObject(getResponseBody()));
            Assert.fail();
        }
    }

    @And("^response body schema should be exactly the same with expected contract$")
    public void response_body_schema_should_be_exactly_the_same_with_expected_contract() {
        Assert.assertEquals("The message result is matching",
                OpenWeatherMapData.API_RESPONSE_BODY_MESSAGE,
                getBodyAsJSONObject(getResponseBody()).getString("message"));
        Assert.assertEquals("The code result is matching",
                OpenWeatherMapData.API_RESPONSE_BODY_CODE_200,
                getBodyAsJSONObject(getResponseBody()).getString("cod"));
        Assert.assertEquals("The ID result is matching",
                OpenWeatherMapData.API_RESPONSE_BODY_ID,
                getObjectInBody(getResponseBody(), "list", 0, "id"));
    }

    @And("^response body should contain attribute name is \"(.*)\" city$")
    public void response_body_should_contain_attribute_name_valid_city(String city) {
        Assert.assertEquals("The city result is matching",
                getObjectInBody(getResponseBody(), "list", 0, "name"),
                OpenWeatherMapData.API_RESPONSE_BODY_NAME);
    }

    @And("^response body is exactly the same as below:$")
    public void response_body_is_exactly_the_same_as_below(Object responseBody) {
        int apiResponseBodyCode = OpenWeatherMapData.API_RESPONSE_BODY_CODE_400;
        Assert.assertEquals(apiResponseBodyCode, getResponseCode());
        Assert.assertEquals("The response body is matching",
                responseBody,
                getBodyAsJSONObject(getResponseBody()));
    }
}
