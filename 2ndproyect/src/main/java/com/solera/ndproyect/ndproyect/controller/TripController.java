package com.solera.ndproyect.ndproyect.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
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
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (trip == null) {
			response.put("mensaje", "ID: ".concat(flightNumber.toString().concat(" no existe")));
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

			response.put("mensaje", "Los campos obligatorios estan vacios");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
	
		try {
			tripNew = tripService.save(trip);
			logger.info("Trip : {}, trip");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			logger.info("Exception : {}", e.getMessage());
			response.put("mensaje", "Titulo ya existente");
			response.put("error","Titulo ya existente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/trips/{flightNumber}")
	public ResponseEntity<?> delete(@PathVariable Long flightNumber) {

		Map<String, Object> response = new HashMap<>();

		try {
			tripService.delete(flightNumber);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Se ha eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
}
