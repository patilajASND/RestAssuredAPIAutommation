package org.testingAcademy.suits.GET;

import io.restassured.RestAssured;

public class BDDStyleRestAssuredcases {

    public static void main(String[] args) {
        // Rest assured  uses Dsl for Writing the test cases
        //which is Dsl Domain Specific Language
        // and it is it uses the method as Given() when()  then().

        // For Given ->
        //url, header,,cookies
        //baseurl=
        // basepath // auth


       // when-> Payload , get method
        // it can be any jason .xml format ex.String,hashmap,object class,


        // then()
        // Response Validation, Status code, time ,header, cookies......

            // Get Request - http://api.Zippopot.us/IN/411057


        RestAssured.given().baseUri("http://api.zippopotam.us/").basePath("/in/431717")
                .when().log().all()
                .get()
                .then().log().all().statusCode(404);


    }
}
