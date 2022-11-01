package com.solera.ndproyect.ndproyect.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {

	@Id
	@Column(name = "ID_TICKET")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTicket;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDTRIP", referencedColumnName = "ID_FLIGHT")
	private Trip idTrip;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPASSENGER", referencedColumnName = "ID_PASSENGER")
	private Passenger idPassenger;
	
	
	public Ticket(Long idTicket, Trip idTrip, Passenger idPassenger) {
		this.idTicket = idTicket;
		this.idTrip = idTrip;
		this.idPassenger = idPassenger;
	}

	public Long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public Trip getIdTrip() {
		return idTrip;
	}

	public void setIdTrip(Trip idTrip) {
		this.idTrip = idTrip;
	}

	public Passenger getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(Passenger idPassenger) {
		this.idPassenger = idPassenger;
	}
	
}
