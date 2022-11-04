package com.solera.ndproyect.ndproyect.repository;

import com.solera.ndproyect.ndproyect.entity.FamousOrigin;
import com.solera.ndproyect.ndproyect.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFamousOrigin extends JpaRepository<FamousOrigin, Long> {
    @Query(value = "SELECT ORIGIN, count(ORIGIN) from TRIPS inner join TICKETS ON TRIPS.ID_FLIGHT= TICKETS.ID_FLIGHT GROUP BY ORIGIN FOR JSON AUTO;", nativeQuery=true)
    public List<FamousOrigin> listOrigins();
}
