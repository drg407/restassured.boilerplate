package restassured.boilerplate.core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
    public static RequestSpecification httpRequest;
    public static Response response;

    public String baseURL = "http://restapi.demoqa.com";
    public static String username = "web@web.com";
    public static String password = "test111";

    @BeforeClass
    public void setUp() {
        // TODO Add new logger
    }

    @AfterClass
    void tearDown() {
        // TODO add logger tear down
    }
}