package com.solera.ndproyect.ndproyect.service;

import java.util.List;

import com.solera.ndproyect.ndproyect.entity.Ticket;

public interface ITicketService {

	public List<Ticket> findAll();
	
	public Ticket findById(Long id);
	
	public Ticket save(Ticket ticket);
	
	public void delete(Long id);
	
}
