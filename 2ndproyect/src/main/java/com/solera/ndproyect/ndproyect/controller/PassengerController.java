package com.solera.ndproyect.ndproyect.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.solera.ndproyect.ndproyect.entity.Passenger;
import com.solera.ndproyect.ndproyect.service.IPassengerService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PassengerController {

	@Autowired
	private IPassengerService passService;
	
	@GetMapping("/passenger")
	public List<Passenger> places() {
		return passService.findAll();
	}
	
	@GetMapping("/passenger/{idPassenger}")
	public ResponseEntity<?> search(@PathVariable Long idPassenger) {
		Passenger passenger = null;
		Map<String, Object> response = new HashMap<>();
		try {
			passenger = passService.findById(idPassenger);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (passenger == null) {
			response.put("mensaje", "ID: ".concat(idPassenger.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Passenger>(passenger, HttpStatus.OK);
	}
	
	@PostMapping("/passenger")
	public ResponseEntity<?> create(@Valid @RequestBody Passenger passenger, BindingResult result)
			throws ParseException {
		Passenger passengerNew = null;
		int age = passenger.getAge();
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getDefaultMessage() + ", " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("mensaje", "Los campos obligatorios estan vacios");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(age == 0){
			passenger.setAge(9);
		}

		try {
			passengerNew = passService.save(passenger);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("mensaje", "Passenger already exists");
			response.put("error","Passenger already exists");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/passenger/{idPassenger}")
	public ResponseEntity<?> delete(@PathVariable Long idPassenger) {

		Map<String, Object> response = new HashMap<>();

		try {
			passService.delete(idPassenger);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Se ha eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
