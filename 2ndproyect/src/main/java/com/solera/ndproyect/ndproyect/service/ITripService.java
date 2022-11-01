package com.solera.ndproyect.ndproyect.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solera.ndproyect.ndproyect.entity.Place;
import com.solera.ndproyect.ndproyect.entity.Trip;

public interface ITripService {

	
	public List<Trip> findAll();
		
	public Trip findById(Long id);
	
	public Trip save(Trip trip);
	
	public void delete(Long id);
			
	/*@Query("SELECT i FROM trips i WHERE (:origin is null or i.origin = :origin) and (:destination is null or i.destination = :destination) and (:departure is null or i.departure = :departure) and (:arrival is null or i.arrival = :arrival) and (:oneWay is null or i.oneWay = :oneWay)")
	List<Trip> findByOriginAndDestinationAndDepartureAndArrivalAndOneWay(@Param("origin") Place origin, @Param("destination") Place destination,@Param("departure") String departure,@Param("arrival") String arrival,@Param("oneWay") Boolean oneWay);
*/
}

