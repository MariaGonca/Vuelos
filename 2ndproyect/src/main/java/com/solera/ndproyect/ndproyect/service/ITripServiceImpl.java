package com.solera.ndproyect.ndproyect.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solera.ndproyect.ndproyect.entity.Trip;
import com.solera.ndproyect.ndproyect.repository.ITripDao;

@Service
public class ITripServiceImpl implements ITripService{

	@Autowired
	private ITripDao tripDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Trip> findAll() {
		return tripDao.findAll();
	}

	@Override
	public Trip findById(Long id) {
		return tripDao.findById(id).orElse(null);
	}

	@Override
	public Trip save(Trip trip) {
		return tripDao.save(trip);
	}

	@Override
	public void delete(Long id) {
		tripDao.deleteById(id);
	}

	@Override
	public List<Trip> findByOriginAndDestAndDepartureAndArrivalAndOneWay(String origin, String dest,
			String departure, String arrival, boolean oneWay) {
		return tripDao.findByOriginAndDestAndDepartureAndArrivalAndOneWay(origin, dest, departure, arrival, oneWay);
	}

	@Override
	public List<Trip> findByOriginAndDestAndDeparture(String origin, String dest, Date departure) {
		return tripDao.findByOriginAndDestAndDeparture(origin, dest, departure);
	}

}
