package com.demoqa.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationApiTests extends BaseTest {

	@Test
	public void registerUserSuccessTest() {
		// Define the registration payload
		String payload = "{ \"userName\": \"johnnysingle\", \"password\": \"Testing123!\" }";

		Response response = RestAssured.given(requestSpec).contentType("application/json").body(payload)
				.post("/Account/v1/User");

		// Validate the response
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.jsonPath().getString("username"), "johnnysingle");
	}

	@Test
	public void registerUserFailureTest() {
		// Incomplete password without special character
		String payload = "{ \"userName\": \"johnnylooser\", \"password\": \"Testing\" }";

		Response response = RestAssured.given(requestSpec).contentType("application/json").body(payload)
				.post("/Account/v1/User");

		// Validate the response
		Assert.assertEquals(response.getStatusCode(), 400);
		Assert.assertEquals(response.jsonPath().getString("message"),
				"Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), "
						+ "one special character and Password must be eight characters or longer.");
	}
}
