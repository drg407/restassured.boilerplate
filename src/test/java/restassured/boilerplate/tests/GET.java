package restassured.boilerplate.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import restassured.boilerplate.core.Base;

public class GET extends Base {

    @BeforeMethod
    void getURL() {
        RestAssured.baseURI = baseURL;
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/utilities/weather/city/Apopka");
    }

    @Test(priority = 1)
    void checkStatusCode() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test(priority = 2)
    void checkResponseBody() {
        String responseBody = response.getBody().jsonPath().prettify();
        Assert.assertTrue(responseBody != null);
    }

    @Test(priority = 3)
    void checkResponseTime() {

        long responseTime = response.getTime();

        if (responseTime > 2000) {
            System.out.println("Response Time is greater than 2000");
        } else
            Assert.assertTrue(responseTime < 2000);
    }
}