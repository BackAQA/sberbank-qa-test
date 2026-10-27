package api;

import api.base.BaseApiTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PetStoreApiTest extends BaseApiTest {

    @Test
    @Description("GET запрос: получение поста по ID")
    public void testGetPost() {
        given()
                .spec(spec)
                .pathParam("postId", 1)
                .when()
                .get("/posts/{postId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue());
    }


    @Test
    @Description("POST запрос: создание нового поста")
    public void testCreatePost() {
        String body = """
                {
                  "title": "foo",
                  "body": "bar",
                  "userId": 1
                }
                """;

        given()
                .spec(spec)
                .contentType("application/json")
                .body(body)
                .log().all()
                .when()
                .post("/posts")
                .then()
                .log().all()
                .statusCode(201)
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("id", notNullValue());
    }
}
