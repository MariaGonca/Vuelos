package com.solera.ndproyect.ndproyect.service;

import java.util.List;

import com.solera.ndproyect.ndproyect.entity.Place;

public interface IPlaceService {

	public List<Place> findAll();
	
	public Place findById(Long id);
	
	public Place save(Place place);
	
	public void delete(Long id);
	
}
