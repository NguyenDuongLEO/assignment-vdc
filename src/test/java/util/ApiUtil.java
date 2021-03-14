package util;

import io.restassured.response.ResponseBody;

public class ApiUtil {
    public static String getDataFromJson(ResponseBody responseBody) {
        return responseBody.prettyPrint();
    }
}
