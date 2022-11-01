package com.solera.ndproyect.ndproyect.service;

import java.util.List;

import com.solera.ndproyect.ndproyect.entity.AirLine;
import com.solera.ndproyect.ndproyect.entity.Passenger;

public interface IPassengerService {

	public List<Passenger> findAll();
	
	public Passenger findById(Long id);
	
	public Passenger save(Passenger passenger);
	
	public void delete(Long id);
}
