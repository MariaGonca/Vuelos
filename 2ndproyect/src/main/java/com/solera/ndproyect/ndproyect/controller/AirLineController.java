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

import com.solera.ndproyect.ndproyect.entity.AirLine;
import com.solera.ndproyect.ndproyect.service.IAirLineService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AirLineController {

	@Autowired
	private IAirLineService airService;
	
	@GetMapping("/airlines")
	public List<AirLine> places() {
		return airService.findAll();
	}
	
	@GetMapping("/airlines/{idAirLine}")
	public ResponseEntity<?> search(@PathVariable Long idAir) {
		AirLine air = null;
		Map<String, Object> response = new HashMap<>();
		try {
			air = airService.findById(idAir);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (air == null) {
			response.put("mensaje", "La iniciativa con ID: ".concat(idAir.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AirLine>(air, HttpStatus.OK);
	}
	
	@PostMapping("/airlines")
	public ResponseEntity<?> create(@Valid @RequestBody AirLine air, BindingResult result)
			throws ParseException {
		AirLine airNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getDefaultMessage() + ", " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("mensaje", "Los campos obligatorios estan vacios");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			airNew = airService.save(air);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("mensaje", "Titulo ya existente");
			response.put("error","Titulo ya existente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@DeleteMapping("/airlines/{idAirLine}")
	public ResponseEntity<?> delete(@PathVariable Long idAirLine) {

		Map<String, Object> response = new HashMap<>();

		try {
			airService.delete(idAirLine);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Se ha eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
