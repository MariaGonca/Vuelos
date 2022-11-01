package com.solera.ndproyect.ndproyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solera.ndproyect.ndproyect.entity.AirLine;

@Repository
public interface IAirLineDao extends JpaRepository<AirLine, Long>{

}
