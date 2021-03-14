package testscripts.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import util.ApiUtil;

public class ApiTest {

    //    @Test
    public static void verifyResponseWhenRequestValidCity() {
        RestAssured.baseURI = "https://openweathermap.org";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/data/2.5/find?type=like&sort=population&cnt=30&appid=439d4b804bc8187953eb36d2a8c26a02&q=ho%20chi%20minh");
        ResponseBody body = response.getBody();


        Assert.assertEquals(ApiUtil.getDataFromJson(body), "123");
        System.out.println("API Testing is PASSED!");
    }
}