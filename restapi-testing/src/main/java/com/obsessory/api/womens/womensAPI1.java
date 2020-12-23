package com.obsessory.api.womens;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class womensAPI1 {

    @Test
    public void search() throws InterruptedException {

        {
            Response response = given()

                    .header("Content-Type", "application/json")
                    .when().get("https://api.obsessory.com/node/api/search?link=/tops&perPage=20&internationaldelivery=GB&country=GB&page=2")
                    .then().extract().response();
            int statusCode = response.statusCode();
            System.out.println(response.asString());
            System.out.println(statusCode);
            Assert.assertEquals(statusCode, 200);
            Object key = response.jsonPath().get("response.data.key");
            System.out.println(key);
            String expected = "Tops for Women";
            Assert.assertEquals(key,expected);


        }
    }
}
