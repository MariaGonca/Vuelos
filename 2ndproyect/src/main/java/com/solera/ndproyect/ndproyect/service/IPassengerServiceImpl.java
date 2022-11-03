package com.solera.ndproyect.ndproyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.ndproyect.ndproyect.entity.Passenger;
import com.solera.ndproyect.ndproyect.repository.IPassengerDao;

@Service
public class IPassengerServiceImpl implements IPassengerService{

	@Autowired
	private IPassengerDao passDao;
	
	@Override
	public List<Passenger> findAll() {
		return passDao.findAll();
	}

	@Override
	public Passenger findById(Long id) {
		return passDao.findById(id).orElse(null);
	}

	@Override
	public Passenger save(Passenger passenger) {
		return passDao.save(passenger);
	}

	@Override
	public void delete(Long id) {
		passDao.deleteById(id);
	}



}
