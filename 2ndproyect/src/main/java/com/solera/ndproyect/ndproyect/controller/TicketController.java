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

import com.solera.ndproyect.ndproyect.entity.Ticket;
import com.solera.ndproyect.ndproyect.service.ITicketService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TicketController {

	@Autowired
	private ITicketService ticketService;
	
	@GetMapping("/tickets")
	public List<Ticket> places() {
		return ticketService.findAll();
	}
	
	@GetMapping("/tickets/{idTicket}")
	public ResponseEntity<?> search(@PathVariable Long idTicket) {
		Ticket ticket = null;
		Map<String, Object> response = new HashMap<>();
		try {
			ticket = ticketService.findById(idTicket);
		} catch (DataAccessException e) {
			response.put("MESSAGE", "Error consulting data base");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (ticket == null) {
			response.put("MESSAGE", "ID: ".concat(idTicket.toString().concat("doesn't exist")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
	
	@PostMapping("/tickets")
	public ResponseEntity<?> create(@Valid @RequestBody Ticket ticket, BindingResult result)
			throws ParseException {
		Ticket ticketNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getDefaultMessage() + ", " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("MESSAGE", "Empty data");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			ticketNew = ticketService.save(ticket);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("MESSAGE", "Already exists");
			response.put("error","Already exists");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@DeleteMapping("/tickets/{idTicket}")
	public ResponseEntity<?> delete(@PathVariable Long idTicket) {

		Map<String, Object> response = new HashMap<>();

		try {
			ticketService.delete(idTicket);
		} catch (DataAccessException e) {
			response.put("MESSAGE", "Error deleting data");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("MESSAGE","The Ticket ".concat(idTicket.toString().concat(" eliminated with success")));

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
