package com.solera.ndproyect.ndproyect.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="trips")
public class Trip implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_FLIGHT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long flight_id;
	
	@Column(name ="AIRLINE_ID")
	private long idAirline;
	
	@Column(name="ORIGIN")
	private String origin;
	
	@Column(name="DEST")
	private String dest;
	
	@Column(name="SCALE")
	@JsonFormat(pattern = "scale")
	@ColumnDefault("false")
	private boolean scale;
	
	@Column(name="LUGGAGE")
	@JsonFormat(pattern = "luggage")
	@ColumnDefault("false")
	private boolean luggage;
	
	@Column(name = "DEPARTURE")
	private LocalDateTime departure;
	
	@Column(name = "ARRIVAL")
	private LocalDateTime arrival;
	
	@Column(name="ONEWAY")
	@JsonFormat(pattern = "oneWay")
	@ColumnDefault("true")
	private boolean oneWay;
	
	@Column(name = "PRICE")
	private float price;
		

	public Trip(boolean scale, boolean luggage, boolean oneWay) {
		this.scale = scale;
		this.luggage = luggage;
		this.oneWay = oneWay;
	}

	public Trip(boolean scale) {
		this.scale = scale;
	}

	public Trip(boolean scale, boolean luggage, boolean oneWay, float price) {
		this.scale = scale;
		this.luggage = luggage;
		this.oneWay = oneWay;
		this.price = price;
	}

	public Trip() {
	}

	public boolean isScale() {
		return scale;
	}

	public void setScale(boolean scale) {
		this.scale = scale;
	}

	public boolean isLuggage() {
		return luggage;
	}

	public void setLuggage(boolean luggage) {
		this.luggage = luggage;
	}

	public LocalDateTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	public LocalDateTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	public boolean isOneWay() {
		return oneWay;
	}

	public void setOneWay(boolean oneWay) {
		this.oneWay = oneWay;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}



	public Trip(long flight_id, long idAirline, boolean scale, boolean luggage, LocalDateTime departure,
			LocalDateTime arrival, boolean oneWay, float price) {
		super();
		this.flight_id = flight_id;
		this.idAirline = idAirline;
		this.scale = scale;
		this.luggage = luggage;
		this.departure = departure;
		this.arrival = arrival;
		this.oneWay = oneWay;
		this.price = price;
	}



	public Trip(long flight_id, long idAirline, boolean scale, boolean luggage, LocalDateTime departure,
			LocalDateTime arrival, boolean oneWay) {
		super();
		this.flight_id = flight_id;
		this.idAirline = idAirline;
		this.scale = scale;
		this.luggage = luggage;
		this.departure = departure;
		this.arrival = arrival;
		this.oneWay = oneWay;
	}



	public Trip(long flight_id, long idAirline, boolean scale, boolean luggage, LocalDateTime departure,
			LocalDateTime arrival) {
		super();
		this.flight_id = flight_id;
		this.idAirline = idAirline;
		this.scale = scale;
		this.luggage = luggage;
		this.departure = departure;
		this.arrival = arrival;
	}



	public Trip(long flight_id, long idAirline, boolean scale, boolean luggage, LocalDateTime departure) {
		super();
		this.flight_id = flight_id;
		this.idAirline = idAirline;
		this.scale = scale;
		this.luggage = luggage;
		this.departure = departure;
	}



	public Trip(long flight_id, long idAirline, boolean scale, boolean luggage) {
		super();
		this.flight_id = flight_id;
		this.idAirline = idAirline;
		this.scale = scale;
		this.luggage = luggage;
	}



	public Trip(long flight_id, long idAirline, boolean scale) {
		super();
		this.flight_id = flight_id;
		this.idAirline = idAirline;
		this.scale = scale;
	}



	public Trip(long flight_id, long idAirline) {
		super();
		this.flight_id = flight_id;
		this.idAirline = idAirline;
	}



	public Trip(long flight_id) {
		super();
		this.flight_id = flight_id;
	}



	@Override
	public String toString() {
		return "Trip [flight_id=" + flight_id + ", idAirline=" + idAirline + ", from=" + origin + ", dest=" + dest
				+ ", scale=" + scale + ", luggage=" + luggage + ", departure=" + departure + ", arrival=" + arrival
				+ ", oneWay=" + oneWay + ", price=" + price + "]";
	}



	/**
	 * @return the flight_id
	 */
	public long getFlight_id() {
		return flight_id;
	}



	/**
	 * @param flight_id the flight_id to set
	 */
	public void setFlight_id(long flight_id) {
		this.flight_id = flight_id;
	}



	/**
	 * @return the idAirline
	 */
	public long getIdAirline() {
		return idAirline;
	}



	/**
	 * @param idAirline the idAirline to set
	 */
	public void setIdAirline(long idAirline) {
		this.idAirline = idAirline;
	}



	/**
	 * @return the from
	 */
	public String getOrigin() {
		return origin;
	}



	/**
	 * @param from the from to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}



	/**
	 * @return the dest
	 */
	public String getDest() {
		return dest;
	}



	/**
	 * @param dest the dest to set
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}



	public Trip(long flight_id, long idAirline, String origin, String dest, boolean scale, boolean luggage,
			LocalDateTime departure, LocalDateTime arrival, boolean oneWay, float price) {
		super();
		this.flight_id = flight_id;
		this.idAirline = idAirline;
		this.origin = origin;
		this.dest = dest;
		this.scale = scale;
		this.luggage = luggage;
		this.departure = departure;
		this.arrival = arrival;
		this.oneWay = oneWay;
		this.price = price;
	}
	
}
