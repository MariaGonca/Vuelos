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

import com.solera.ndproyect.ndproyect.entity.Place;
import com.solera.ndproyect.ndproyect.service.IPlaceService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PlaceController {

	@Autowired
	private IPlaceService placeService;
	
	@GetMapping("/places")
	public List<Place> places() {
		return placeService.findAll();
	}
	
	@GetMapping("/places/{idPlace}")
	public ResponseEntity<?> search(@PathVariable Long idPlace) {
		Place place = null;
		Map<String, Object> response = new HashMap<>();
		try {
			place = placeService.findById(idPlace);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (place == null) {
			response.put("mensaje", "ID: ".concat(idPlace.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Place>(place, HttpStatus.OK);
	}
	
	@PostMapping("/places")
	public ResponseEntity<?> create(@Valid @RequestBody Place place, BindingResult result)
			throws ParseException {
		Place placeNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getDefaultMessage() + ", " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("mensaje", "Los campos obligatorios estan vacios");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			placeNew = placeService.save(place);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("mensaje", "Titulo ya existente");
			response.put("error","Titulo ya existente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/places/{idPlace}")
	public ResponseEntity<?> delete(@PathVariable Long idPlace) {

		Map<String, Object> response = new HashMap<>();

		try {
			placeService.delete(idPlace);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Se ha eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}

