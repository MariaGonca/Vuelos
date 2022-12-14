package com.solera.ndproyect.ndproyect.repository;

import com.solera.ndproyect.ndproyect.entity.FamousOrigin;
import com.solera.ndproyect.ndproyect.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.solera.ndproyect.ndproyect.entity.Ticket;

import java.util.Date;
import java.util.List;

@Repository
public interface ITicketDao extends JpaRepository<Ticket, Long>{

    @Query(value = "SELECT ORIGIN, count(ORIGIN) from TRIPS inner join TICKETS ON TRIPS.ID_FLIGHT= TICKETS.ID_FLIGHT GROUP BY ORIGIN FOR JSON AUTO;", nativeQuery=true)
    public List<FamousOrigin> listOrigins();

    //CORRECTA:
    //SELECT ORIGIN, count(ORIGIN) from TRIPS inner join TICKETS ON TRIPS.ID_FLIGHT= TICKETS.ID_FLIGHT GROUP BY ORIGIN;


}
