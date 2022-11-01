package com.solera.ndproyect.ndproyect.service;

import java.util.List;

import com.solera.ndproyect.ndproyect.entity.AirLine;
import com.solera.ndproyect.ndproyect.entity.Trip;

public interface IAirLineService {

	public List<AirLine> findAll();
	
	public AirLine findById(Long id);
	
	public AirLine save(AirLine airline);
	
	public void delete(Long id);
}
