package com.solera.ndproyect.ndproyect.controller;

import java.text.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solera.ndproyect.ndproyect.entity.Trip;
import com.solera.ndproyect.ndproyect.service.ITripService;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TripController {

	@Autowired
	private ITripService tripService;
	
	@GetMapping("/trips")
	public List<Trip> places() {
		return tripService.findAll();
	}
	
	@GetMapping("/trips/{flightNumber}")
	public ResponseEntity<?> search(@PathVariable Long flightNumber) {
		Trip trip = null;
		Map<String, Object> response = new HashMap<>();
		try {
			trip = tripService.findById(flightNumber);
		} catch (DataAccessException e) {
			response.put("MESSAGE", "Error consulting data base");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (trip == null) {
			response.put("MESSAGE", "ID: ".concat(flightNumber.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Trip>(trip, HttpStatus.OK);
	}
	
	@PostMapping("/trips")
	public ResponseEntity<?> create(@Valid @RequestBody Trip trip, BindingResult result)
			throws ParseException {
		Trip tripNew = null;
		Logger logger = LoggerFactory.getLogger(TripController.class);
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getDefaultMessage() + ", " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("MESSAGE", "Empty data");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
	
		try {
			tripNew = tripService.save(trip);
			logger.info("Trip : {}, trip");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			logger.info("Exception : {}", e.getMessage());
			response.put("MESSAGE", "Already exists");
			response.put("error","Already exists");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/trips/{flightNumber}")
	public ResponseEntity<?> delete(@PathVariable Long flightNumber) {

		Map<String, Object> response = new HashMap<>();

		try {
			tripService.delete(flightNumber);
		} catch (DataAccessException e) {
			response.put("MESSAGE", "Error deleting");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("MESSAGE","The Trip ".concat(flightNumber.toString().concat(" eliminated with success")));

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/trips/filter")
	public ResponseEntity<?> tripsByAllParams(@RequestParam String origin, String dest, String departure, String arrival, Boolean oneWay) {
		Map<String, Object> response = new HashMap<>();
		List<Trip> trip;
		List<Trip> tripReturn;

		String originNew;
		String destNew;
		try {
			
			if (origin.equals("")) {
				origin = null;
			}
			if (dest.equals("")) {
				dest = null;
			}
			if (departure.equals("")) {
				departure = null;
			}
			if (arrival.equals("")) {
				arrival = null;
			}
			trip = tripService.findByOriginAndDestAndDepartureAndArrivalAndOneWay(origin, dest, departure, arrival, oneWay);
		} catch (DataAccessException e) {
			response.put("MESSAGE", "Error consulting data base");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (trip == null) {
			response.put("MESSAGE", "trip : ".concat(origin.toString().concat(" doesn't exist")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Trip>>(trip, HttpStatus.OK);
	}

	@GetMapping("/trips/filterReturn")
	public ResponseEntity<?> tripsReturn(@RequestParam String origin, String dest, String departure, String arrival) {
		Map<String, Object> response = new HashMap<>();

		List<Trip> tripReturn;

		String originNew;
		String destNew;
		String departureNew;
		try {
			originNew = dest;
			destNew = origin;
			departureNew = arrival;

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
			Date date = formatter.parse(departureNew);
			tripReturn = tripService.findByOriginAndDestAndDeparture(originNew, destNew, date);
		} catch (DataAccessException | ParseException e) {
			response.put("MESSAGE", "Error consulting data base");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (tripReturn == null) {
			response.put("MESSAGE", "trip : ".concat(origin.toString().concat(" doesn't exist")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Trip>>(tripReturn, HttpStatus.OK);
	}
}
