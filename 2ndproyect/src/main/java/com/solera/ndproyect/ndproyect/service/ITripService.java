package com.solera.ndproyect.ndproyect.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.solera.ndproyect.ndproyect.entity.Trip;

public interface ITripService {

	
	public List<Trip> findAll();
		
	public Trip findById(Long id);
	
	public Trip save(Trip trip);
	
	public void delete(Long id);
	
	@Query("SELECT i FROM Trip i WHERE (:origin is null or i.origin LIKE %:origin%) and (:dest is null or i.dest LIKE %:dest%) and (i.departure = :departure) and (i.arrival = :arrival) and (:oneWay is null or i.oneWay = :oneWay)")
	public List<Trip> findByOriginAndDestAndDepartureAndArrivalAndOneWay(String origin, String dest, String departure, String arrival, boolean oneWay);
	
	@Query("SELECT i FROM Trip i WHERE (:origin is null or i.origin LIKE %:origin%) and (:dest is null or i.dest LIKE %:dest%) and (i.departure >= :departure)")
	public List<Trip> findByOriginAndDestAndDeparture(String origin, String dest, Date departure);
}

