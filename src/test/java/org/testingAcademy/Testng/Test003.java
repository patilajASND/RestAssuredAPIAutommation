package org.testingAcademy.Testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Test003 {
    // Put Request
    // Before -Token , ID

RequestSpecification requestSpecification;
ValidatableResponse validatableResponse;
String token;
@Test
 public void getToken(){
     requestSpecification  = RestAssured.given();
     String Payload = "{\n" +
             "    \"username\" : \"admin\",\n" +
             "    \"password\" : \"password123\"\n" +
             "}";

     requestSpecification.baseUri("https://restful-booker.herokuapp.com");
     requestSpecification.basePath("/auth");
     requestSpecification.contentType(ContentType.JSON).log().all();
     requestSpecification.body(Payload);
     Response response = requestSpecification.post();
     validatableResponse =response.then();
     validatableResponse.body("token", Matchers.notNullValue());
    System.out.println(token);
     token = response.then().log().all().extract().path("token");
    Assert.assertNotNull("token");


//     assertThat(token).isNotNull.isNotBlank().isNotEmpty();
//    System.out.println(token);
}

    public void testNonBDDStylePutReq(){



    }
}
