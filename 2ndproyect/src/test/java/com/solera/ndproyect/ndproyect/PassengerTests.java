package com.solera.ndproyect.ndproyect;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest
class PassengerTests {
	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllPassengers_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/passenger")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}
	
	@Test
	void getSpecificPassenger_success_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/passenger/1")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}

	@Test
	void getSpecificPassenger_fail_test() {
		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/passenger/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(404, response.statusCode());

	}
	
	@Test
	void postCreatePassenger_success_test() {
		String requestBody = "{\n" +
	            "  \"name\": \"Giovanni\",\n" +
	            "  \"unsername\": \"Giorgio\",\n" +
	            "  \"nationality\": \"Italian\",\n" +
	            "  \"identification\": \"ZX9876\", \n" +
	            "  \"age\": 30 \n}";

		Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
				.post("http://localhost:8080/api/passenger").then().log().all().extract().response();

		Assertions.assertEquals(201, response.statusCode());

	}
	
	@Test
	void postCreatePassenger_fail_test() {
		String requestBody = "{\n" +
	            "  \"name\": \"Mario\",\n" +
	            "  \"unsername\": \"Rossi\",\n" +
	            "  \"nationality\": \"Italian\",\n" +
	            "  \"identification\": \"CD5678\", \n" +
	            "  \"age\": 25 \n}";
		Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
				.post("http://localhost:8080/api/passenger").then().log().all().extract().response();

		Assertions.assertEquals(500, response.statusCode());

	}
	
	@Test
	void deleteSpecificPassenger_success_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/passenger/3")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}
	
	@Test
	void deleteSpecificPassenger_fail_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/passenger/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(500, response.statusCode());
	}
	
}
