package com.solera.ndproyect.ndproyect.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="airlines")
public class AirLine {

	@Id
	@Column(name = "ID_AIRLINE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAirLine;
	
	@Column(name = "NAME", unique=true)
	@NotNull
	@NotEmpty
	private String name;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Trip> trip = new HashSet<Trip>();
	
	public AirLine(Long idAirLine, String name) {
		this.idAirLine = idAirLine;
		this.name = name;
	}
	
	public AirLine() {
	}
	
	public AirLine(@NotNull @NotEmpty String name) {
		super();
		this.name = name;
	}

	public Long getIdAirLine() {
		return idAirLine;
	}

	public void setIdAirLine(Long idAirLine) {
		this.idAirLine = idAirLine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the trip
	 */
	public Set<Trip> getTrip() {
		return trip;
	}

	/**
	 * @param trip the trip to set
	 */
	public void setTrip(Set<Trip> trip) {
		this.trip = trip;
	}

	@Override
	public String toString() {
		return "AirLine [idAirLine=" + idAirLine + ", name=" + name + ", trip=" + trip + "]";
	}

}
