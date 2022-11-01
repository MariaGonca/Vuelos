package com.solera.ndproyect.ndproyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.ndproyect.ndproyect.entity.Ticket;
import com.solera.ndproyect.ndproyect.repository.IPassengerDao;
import com.solera.ndproyect.ndproyect.repository.ITicketDao;

@Service
public class ITicketServiceImpl implements ITicketService{

	@Autowired
	private ITicketDao ticketDao;
	
	@Override
	public List<Ticket> findAll() {
		return ticketDao.findAll();
	}

	@Override
	public Ticket findById(Long id) {
		return ticketDao.findById(id).orElse(null);
	}

	@Override
	public Ticket save(Ticket ticket) {
		return ticketDao.save(ticket);
	}

	@Override
	public void delete(Long id) {
		ticketDao.deleteById(id);		
	}

}
