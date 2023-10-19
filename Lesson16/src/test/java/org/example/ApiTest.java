package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest
{

    @BeforeEach
    public void configureRestAssured() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void
    getRequestTest() {
        given()
                .param("hi", "there")
                .param("hand", "wave")
                .when().get("/get")
                .then().log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and().body("args.hi", equalTo("there"))
                .and().body("args.hand", equalTo("wave"))

                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo(baseURI + "/get?hi=there&hand=wave"));
    }

    @Test
    public void postRawTextRequestTest() {
        given().body("This is expected to be sent back as part of response body.")
                .when().post("/post")
                .then().log().body()
                .statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."))

                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .and().body("url", equalTo(baseURI + "/post"));
    }

    @Test
    public void postFormDataTest() {
        given()
                .headers("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("hi", "there")
                .formParam("hand", "wave")
                .when().post("/post")
                .then().log().body()
                .statusCode(200)
                .and().body("form.hi", equalTo("there"))
                .and().body("form.hand", equalTo("wave"))
                .and().body("json.hi", equalTo("there"))
                .and().body("json.hand", equalTo("wave"))

                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("headers.content-length", equalTo("18"))
                .and().body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"))
                .and().body("url", equalTo(baseURI + "/post"));
    }

    @Test
    public void putRequestTest() {
        given().body("This is expected to be sent back as part of response body.")
                .when().put("/put")
                .then().log().body()
                .statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."))

                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .and().body("url", equalTo(baseURI + "/put"));
    }

    @Test
    public void patchRequestTest() {
        given().body("This is expected to be sent back as part of response body.")
                .when().patch("/patch")
                .then().log().body()
                .statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."))

                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .and().body("url", equalTo(baseURI + "/patch"));
    }

    @Test
    public void deleteRequestTest() {
        given().body("This is expected to be sent back as part of response body.")
                .when().delete("/delete")
                .then().log().body()
                .statusCode(200)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."))

                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .and().body("url", equalTo(baseURI + "/delete"));
    }
}
