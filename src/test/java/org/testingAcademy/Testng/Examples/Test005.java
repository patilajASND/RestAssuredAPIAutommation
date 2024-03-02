package org.testingAcademy.Testng.Examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test005 {
   String token;
   Integer bookingid;
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;


    @BeforeTest
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
    }


    @BeforeTest
    public void GetBookingid(){
        System.out.println("getBookingid");
        requestSpecification  = RestAssured.given();
        String Payload ="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : [\"Breakfast\",\"Lunch\"]\n" +
                "}";


        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(Payload);


        Response response =  requestSpecification.when().post();


        ValidatableResponse validatableResponse =response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        bookingid = response.then().log().all().extract().path("bookingid");
        System.out.println(bookingid);
    }
    @Test
    public void testPutReq(){
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
