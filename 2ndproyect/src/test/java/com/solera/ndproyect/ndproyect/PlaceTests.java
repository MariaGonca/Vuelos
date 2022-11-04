package com.solera.ndproyect.ndproyect;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest
class PlaceTests {
	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllPlaces_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/places")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}

	@Test
	void getSpecificPlace_success_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/places/1")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}
	
	@Test
	void getSpecificPlace_fail_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/places/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(404, response.statusCode());

	}
	
	@Test
	void postCreatePlace_success_test() {
		String requestBody = "{\n" +
	            "  \"name\": \"Berlin\"}";

		Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
				.post("http://localhost:8080/api/places").then().log().all().extract().response();

		Assertions.assertEquals(201, response.statusCode());

	}
	
	@Test
	void postCreatePlace_fail_test() {
		String requestBody = "{\n" +
	            "  \"name\": \"Rome\"}";

		Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
				.post("http://localhost:8080/api/places").then().log().all().extract().response();

		Assertions.assertEquals(500, response.statusCode());

	}
	
	@Test
	void deleteSpecificPlace_success_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/places/5")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}
	
	@Test
	void deleteSpecificPlace_fail_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/places/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(500, response.statusCode());
	}

}
