package com.obsessory.api.search;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class searchAPI3 {

    @Test
    public void search() throws InterruptedException {

        {
            Response response = given()

                    .header("Content-Type", "application/json")
                    .when().get("https://api.obsessory.com/node/api/search?q=shoes&perPage=20&department=kids&country=GB&internationaldelivery=GB&page=2")
                    .then().extract().response();
            int statusCode = response.statusCode();
            System.out.println(response.asString());
            System.out.println(statusCode);
            Assert.assertEquals(statusCode, 200);
            Object key = response.jsonPath().get("response.data.key");
            System.out.println(key);
            String expected = "Shoes for Kids";
            Assert.assertEquals(key,expected);


        }
    }
}
