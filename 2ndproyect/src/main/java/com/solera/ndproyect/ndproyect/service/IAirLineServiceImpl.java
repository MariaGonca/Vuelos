package com.solera.ndproyect.ndproyect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solera.ndproyect.ndproyect.entity.AirLine;
import com.solera.ndproyect.ndproyect.repository.IAirLineDao;

@Service
public class IAirLineServiceImpl implements IAirLineService{

	@Autowired
	private IAirLineDao airDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<AirLine> findAll() {
		return airDao.findAll();
	}

	@Override
	public AirLine findById(Long id) {
		return airDao.findById(id).orElse(null);
	}

	@Override
	public AirLine save(AirLine airline) {
		return airDao.save(airline);
	}

	@Override
	public void delete(Long id) {
		airDao.deleteById(id);	
	}

}
