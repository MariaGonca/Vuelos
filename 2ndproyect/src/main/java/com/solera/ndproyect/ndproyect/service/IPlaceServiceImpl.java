package com.solera.ndproyect.ndproyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.ndproyect.ndproyect.entity.Place;
import com.solera.ndproyect.ndproyect.repository.IPlaceDao;

@Service
public class IPlaceServiceImpl implements IPlaceService{

	@Autowired
	private IPlaceDao placeDao;
	
	@Override
	public List<Place> findAll() {
		return placeDao.findAll();
	}

	@Override
	public Place findById(Long id) {
		return placeDao.findById(id).orElse(null);
	}

	@Override
	public Place save(Place place) {
		return placeDao.save(place);
	}

	@Override
	public void delete(Long id) {
		placeDao.deleteById(id);
		
	}

}
