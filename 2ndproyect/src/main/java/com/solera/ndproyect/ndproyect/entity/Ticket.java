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

	/** The id ticket. */
	@Id
	@Column(name = "ID_TICKET")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTicket;
	
	/** The id trip. */
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_FLIGHT")
	private Trip idTrip;
	
	/** The id passenger. */
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_PASSENGER")
	private Passenger idPassenger;
	
	
	/**
	 * Instantiates a new ticket.
	 *
	 * @param idTicket the id ticket
	 * @param idTrip the id trip
	 * @param idPassenger the id passenger
	 */
	public Ticket(Long idTicket, Trip idTrip, Passenger idPassenger) {
		this.idTicket = idTicket;
		this.idTrip = idTrip;
		this.idPassenger = idPassenger;
	}

	/**
	 * Gets the id ticket.
	 *
	 * @return the id ticket
	 */
	public Long getIdTicket() {
		return idTicket;
	}

	/**
	 * Sets the id ticket.
	 *
	 * @param idTicket the new id ticket
	 */
	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	/**
	 * Gets the id trip.
	 *
	 * @return the id trip
	 */
	public Trip getIdTrip() {
		return idTrip;
	}

	/**
	 * Sets the id trip.
	 *
	 * @param idTrip the new id trip
	 */
	public void setIdTrip(Trip idTrip) {
		this.idTrip = idTrip;
	}

	/**
	 * Gets the id passenger.
	 *
	 * @return the id passenger
	 */
	public Passenger getIdPassenger() {
		return idPassenger;
	}

	/**
	 * Sets the id passenger.
	 *
	 * @param idPassenger the new id passenger
	 */
	public void setIdPassenger(Passenger idPassenger) {
		this.idPassenger = idPassenger;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", idTrip=" + idTrip + ", idPassenger=" + idPassenger + "]";
	}
	
}
