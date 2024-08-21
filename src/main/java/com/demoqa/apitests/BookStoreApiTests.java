package com.demoqa.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreApiTests extends BaseTest {

    @Test
    public void getBooksTest() {
        Response response = RestAssured.given(requestSpec)
            .get("/BookStore/v1/Books");

        // Validate the response
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("books").size() > 0);
    }
}
