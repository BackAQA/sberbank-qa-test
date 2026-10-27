package api.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    protected static RequestSpecification spec;

    @BeforeAll
    public static void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .addFilter(new AllureRestAssured())
                .build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
