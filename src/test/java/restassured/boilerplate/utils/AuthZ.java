package restassured.boilerplate.utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import restassured.boilerplate.core.Base;

public class AuthZ extends Base {
    public static String getAuthzToken() {

        Response response = RestAssured.given().auth().none().contentType("application/x-www-form-urlencoded").log()
                .all().formParam("grant_type", "password").formParam("client_id", "FILL THIS IN")
                .formParam("username", username).formParam("password", password)
                .formParam("assertion_type", "FILL THIS IN").when().post("https://authorizationURLgoeshere/token");

        JsonPath responseBody = response.jsonPath();
        logger.info("Access Token is:  " + responseBody.get("access_token").toString());

        return responseBody.get("access_token").toString();
    }
}