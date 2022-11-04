package com.solera.ndproyect.ndproyect;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest
class TripTests {
	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllTrips_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/trips")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}
	
	@Test
	void getSpecificTrip_success_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/trips/1")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}
	
	@Test
	void getSpecificTrip_fail_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/trips/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(404, response.statusCode());

	}
	
	@Test
	void postCreateTrip_success_test() {
		String requestBody = "{\n" +
	            "  \"idAirline\": 1,\n" +
	            "  \"origin\": \"Rome\",\n" +
	            "  \"dest\": \"Seville\",\n" +
	            "  \"scale\": false, \n" +
	            "  \"luggage\": true, \n" +
	            "  \"departure\": \"2022-11-18T10:00:49.455\",\n" +
	            "  \"arrival\": \"2022-11-18T20:00:00.000\",\n" +
	            "  \"oneWay\": true, \n" +
	            "  \"price\": 299.99 \n}";

		Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
				.post("http://localhost:8080/api/trips").then().log().all().extract().response();

		Assertions.assertEquals(201, response.statusCode());

	}
	
	@Test
	void deleteSpecificTrip_success_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/trips/3")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}
	
	@Test
	void deleteSpecificTrip_fail_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/trips/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(500, response.statusCode());
	}
	
	@Test
	void getFilters_test() {
		//filters parameters
		String origin="Rome";
		String dest="Madrid";
		String departure="2022-11-18T16:00:49.455";
		String arrival="2022-11-18T20:00:49.455";
		boolean oneWay=false;
		
		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/trips/filter?origin="+origin+"&dest="+dest+"&departure="+departure+"&arrival="+arrival+"&oneWay="+oneWay)
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

		
	}

}
