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
        logger.info("***TESTING APOPKA WEATHER***");
        RestAssured.baseURI = baseURL;
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/utilities/weather/city/Apopka");
    }

    @Test(priority = 1)
    void checkStatusCode() {
        logger.info("Checking Status Code!!!");
        int statusCode = response.getStatusCode();
        logger.info("Status Code Is:  " + statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    @Test(priority = 2)
    void checkResponseBody() {
        logger.info("Checking Response Body!!!");
        String responseBody = response.getBody().jsonPath().prettify();
        logger.info("Response Body:  " + responseBody);
        Assert.assertTrue(responseBody != null);
    }

    @Test(priority = 3)
    void checkResponseTime() {
        logger.info("Checking Response Time!!!");
        long responseTime = response.getTime();
        logger.info("Response Time is:  " + responseTime);
        if (responseTime > 2000) {
            logger.warn("Response Time is greater than 2000");
        } else
            Assert.assertTrue(responseTime < 2000);
    }
}