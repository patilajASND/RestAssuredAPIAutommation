package org.testingAcademy.suits.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class nonBDDPUT {
   RequestSpecification requestSpecification;
   ValidatableResponse validatableResponse;

    String token = "cbd17d142e0c2f6";

@Test
    public void testPutRequest() {

        String payload= "{\n" +
                "    \"firstname\" : \"omkar\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
              requestSpecification = RestAssured.given();
              requestSpecification.baseUri("https://restful-booker.herokuapp.com/booking");
              requestSpecification.basePath("/27");
              requestSpecification.contentType(ContentType.JSON);
              requestSpecification.cookie("token",token);
              requestSpecification.body(payload).log().all();

              Response resonse = requestSpecification.when().put();


              // validation

        validatableResponse =resonse.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("omkar"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));


    }
}
