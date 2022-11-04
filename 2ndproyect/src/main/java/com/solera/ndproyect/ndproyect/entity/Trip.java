package com.solera.ndproyect.ndproyect.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

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
	private Boolean scale;
	
	@Column(name="LUGGAGE")
	@JsonFormat(pattern = "luggage")
	@ColumnDefault("false")
	private Boolean luggage;
	
	@Column(name = "DEPARTURE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String departure;
	
	@Column(name = "ARRIVAL")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String arrival;
	
	@Column(name="ONEWAY")
	@JsonFormat(pattern = "oneWay")
	@ColumnDefault("true")
	private Boolean oneWay;
	
	@Column(name = "PRICE")
	private float price;

	public Trip(long flight_id, long idAirline, String origin, String dest, Boolean scale, Boolean luggage,
			String departure, String arrival, Boolean oneWay, float price) {
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

	public Trip(long idAirline, String origin, String dest, Boolean scale, Boolean luggage, String departure,
			String arrival, Boolean oneWay, float price) {
		super();
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

	public Trip() {
		super();
	}

	public long getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(long flight_id) {
		this.flight_id = flight_id;
	}

	public long getIdAirline() {
		return idAirline;
	}

	public void setIdAirline(long idAirline) {
		this.idAirline = idAirline;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public Boolean getScale() {
		return scale;
	}

	public void setScale(Boolean scale) {
		this.scale = scale;
	}

	public Boolean getLuggage() {
		return luggage;
	}

	public void setLuggage(Boolean luggage) {
		this.luggage = luggage;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public Boolean getOneWay() {
		return oneWay;
	}

	public void setOneWay(Boolean oneWay) {
		this.oneWay = oneWay;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
