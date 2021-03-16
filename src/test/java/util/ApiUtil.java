package util;

import io.restassured.response.Response;
import org.json.JSONObject;

public class ApiUtil {

    public static JSONObject getBodyAsJSONObject(Response response) {
        return new JSONObject(response.getBody().asString());
    }

    public static Object getObjectInBody(Response response, String arrayName, int index, String getName) {
        return new JSONObject(response.getBody().asString()).getJSONArray(arrayName).getJSONObject(index).get(getName);
    }
}
