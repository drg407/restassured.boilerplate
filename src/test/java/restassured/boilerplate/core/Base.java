package restassured.boilerplate.core;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
    public static RequestSpecification httpRequest;
    public static Response response;

    public static Logger logger;

    public String baseURL = "http://restapi.demoqa.com";
    public static String username = "web@web.com";
    public static String password = "test111";

    @BeforeClass
    public void setUp() {
        logger = Logger.getLogger("RestAPI");
        PropertyConfigurator.configure("src/log4j.properties");
        logger.setLevel(Level.DEBUG);
    }

    @AfterClass
    void tearDown() {
        logger.info("Finished!!!");
    }
}