package org.testingAcademy.suits.GET;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
public class NOnBDDStyleTestNG {
    RequestSpecification r ;

    @Test

    public void testGetAllBookingPositive(){
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/ 200").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);
    }

    @Test
    public void testGetAllBookingNegative(){
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);

    }
}
