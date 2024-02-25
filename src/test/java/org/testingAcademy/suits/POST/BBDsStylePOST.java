package org.testingAcademy.suits.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class BBDsStylePOST {
    @Test
    public void BBDsStylePOSTPOsitive() {


        String Payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        RestAssured.
                given().
                baseUri("https://restful-booker.herokuapp.com").
                basePath("/auth").contentType(ContentType.JSON).log().all()
                .body(Payload).when().post()
                .then().log().all().statusCode(200);
        }

    }