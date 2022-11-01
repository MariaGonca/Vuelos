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
	private Long flightNumber;
	
	@ManyToOne
    @JoinColumn(name = "idOrigin", referencedColumnName = "ID_PLACE")
	private Place origin;
	
	@ManyToOne
    @JoinColumn(name = "idDestination", referencedColumnName = "ID_PLACE")
	private Place destination;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAirline", referencedColumnName = "ID_AIRLINE")
	private AirLine airline;
	
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
		
	public Trip(Long flightNumber, Place origin, Place destination, AirLine airline, boolean scale, boolean luggage,
			LocalDateTime departure, LocalDateTime arrival, boolean oneWay, float price) {
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.airline = airline;
		this.scale = scale;
		this.luggage = luggage;
		this.departure = departure;
		this.arrival = arrival;
		this.oneWay = oneWay;
		this.price = price;
	}

	
	
	
	public Trip(AirLine airline, boolean scale, boolean luggage,
			boolean oneWay, float price) {
		this.airline = airline;
		this.scale = scale;
		this.luggage = luggage;
		this.oneWay = oneWay;
		this.price = price;
	}


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

	public Trip(Place origin, Place destination, AirLine airline, boolean scale, boolean luggage, boolean oneWay,
			float price) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.airline = airline;
		this.scale = scale;
		this.luggage = luggage;
		this.oneWay = oneWay;
		this.price = price;
	}

	public Trip(Place origin, Place destination, AirLine airline, boolean scale, boolean luggage,
			LocalDateTime departure, LocalDateTime arrival, boolean oneWay, float price) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.airline = airline;
		this.scale = scale;
		this.luggage = luggage;
		this.departure = departure;
		this.arrival = arrival;
		this.oneWay = oneWay;
		this.price = price;
	}

	public Trip(Long flightNumber, Place origin, Place destination, AirLine airline, boolean scale, boolean luggage,
			boolean oneWay, float price) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.airline = airline;
		this.scale = scale;
		this.luggage = luggage;
		this.oneWay = oneWay;
		this.price = price;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Place getOrigin() {
		return origin;
	}

	public void setOrigin(Place origin) {
		this.origin = origin;
	}

	public Place getDestination() {
		return destination;
	}

	public void setDestination(Place destination) {
		this.destination = destination;
	}

	public AirLine getAirline() {
		return airline;
	}

	public void setAirline(AirLine airline) {
		this.airline = airline;
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
	
}
