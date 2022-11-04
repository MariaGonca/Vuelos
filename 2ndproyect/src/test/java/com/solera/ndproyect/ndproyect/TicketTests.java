package com.solera.ndproyect.ndproyect;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest
class TicketTests {
	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllTickets_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/tickets")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}

	@Test
	void getSpecificTicket_success_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/tickets/1")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());

	}
	
	@Test
	void getSpecificTicket_fail_test() {

		Response response = given().contentType(ContentType.JSON).when().get("http://localhost:8080/api/tickets/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(404, response.statusCode());

	}
	
	@Test
	void postCreateTicket_success_test() {
		String requestBody = "{\n" +
				"  \"idTrip\":{\n"+
				"  \"idAirline\": 88,\n" +
				"  \"origin\": \"Venice\",\n" +
				"  \"dest\": \"Seville\",\n" +
	            "  \"scale\": true, \n" +
	            "  \"luggage\": true, \n" +
	            "  \"departure\": \"2022-11-27T23:00:49.455\",\n" +
	            "  \"arrival\": \"2022-11-28T05:00:49.455\",\n" +
	            "  \"oneWay\": false, \n" +
	            "  \"price\": 450 \n},"+
	            "  \"idPassenger\":{\n"+
	            "  \"name\": \"Jackie\",\n" +
	            "  \"unsername\": \"Ye\",\n" +
	            "  \"nationality\": \"Irish\",\n" +
	            "  \"identification\": \"ZZ76543\", \n" +
	            "  \"age\": 8 \n}\n}";

		Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
				.post("http://localhost:8080/api/tickets").then().log().all().extract().response();

		Assertions.assertEquals(201, response.statusCode());

	}
	
	@Test
	void postCreateTicket_fail_test() {
		String requestBody = "{\n" +
				"  \"idTrip\":{\n"+
				"  \"idAirline\": 1,\n" +
				"  \"origin\": \"Venice\",\n" +
				"  \"dest\": \"Seville\",\n" +
	            "  \"scale\": true, \n" +
	            "  \"luggage\": true, \n" +
	            "  \"departure\": \"2022-11-27T23:00:49.455\",\n" +
	            "  \"arrival\": \"2022-11-28T05:00:49.455\",\n" +
	            "  \"oneWay\": false, \n" +
	            "  \"price\": 450 \n},"+
	            "  \"idPassenger\":{\n"+
	            "  \"name\": \"Cristian\",\n" +
	            "  \"unsername\": \"Sandu\",\n" +
	            "  \"nationality\": \"Romanian\",\n" +
	            "  \"identification\": \"AB12345\", \n" +
	            "  \"age\": 20 \n}\n}";

		Response response = given().header("Content-type", "application/json").and().body(requestBody).when()
				.post("http://localhost:8080/api/tickets").then().log().all().extract().response();

		Assertions.assertEquals(500, response.statusCode());

	}
	
	@Test
	void deleteSpecificTicket_success_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/tickets/2")
				.then().log().all().extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}
	
	@Test
	void deleteSpecificTicket_fail_test() {

		Response response = given().contentType(ContentType.JSON).when().delete("http://localhost:8080/api/tickets/999")
				.then().log().all().extract().response();

		Assertions.assertEquals(500, response.statusCode());
	}

}
