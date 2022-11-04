package com.solera.ndproyect.ndproyect;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest
class AirLineTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllAirline_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/airlines")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}

	@Test
	void getSpecificAirline_success_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/airlines/1")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}

	@Test
	void getSpecificAirline_fail_test() {
		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/airlines/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(404, response.statusCode());

	}

	@Test
	void postCreateNewAirline_success_test() {
		String requestBody = "{\n" + "  \"name\": \"Alitalia\"\n}";

		Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
				.post("http://localhost:8080/api/airlines").then().log().all().extract().response();

		Assertions.assertEquals(201, response.statusCode());

	}

	@Test
	void postCreateNewAirline_fail_test() {
		String requestBody = "{\n" + "  \"name\": \"Ryanair\"\n}";

		Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
				.post("http://localhost:8080/api/airlines").then().log().all().extract().response();

		Assertions.assertEquals(500, response.statusCode());

	}

	@Test
	void deleteSpecificAirline_success_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/airlines/2")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}
	
	@Test
	void deleteSpecificAirline_fail_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/airlines/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(500, response.statusCode());
	}
}
