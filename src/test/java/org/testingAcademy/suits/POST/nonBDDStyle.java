package org.testingAcademy.suits.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class nonBDDStyle {
    @Test
    public void nonBBDsStylePOSTPOsitive() {

        RequestSpecification r = RestAssured.given();
        String Payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

               r.baseUri("https://restful-booker.herokuapp.com");
               r.basePath("/auth");
               r.contentType(ContentType.JSON).log().all();
                r.body(Payload);


                Response response = r.when().post();


       ValidatableResponse validatableResponse =response.then();
                String responseString = response.asString();
                System.out.println(responseString);

        validatableResponse.statusCode(200);
    }


}
