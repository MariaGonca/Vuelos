package com.solera.ndproyect.ndproyect.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="places")
public class Place {

	@Id
	@Column(name = "ID_PLACE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlace;
	
	@Column(name = "NAME", unique=true)
	@NotNull
	@NotEmpty
	private String name;

	@OneToMany(mappedBy = "destination")
	private List<Trip> trip;
	
	public Place(String name) {
		this.name = name;
	}

	public Place() {
	}

	
	public Place(Long idPlace, String name) {
		this.idPlace = idPlace;
		this.name = name;
	}

	public Place(Long idPlace, String name, List<Trip> trip) {
		this.idPlace = idPlace;
		this.name = name;
		this.trip = trip;
	}

	public Long getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Long idPlace) {
		this.idPlace = idPlace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Trip> getTrip() {
		return trip;
	}

	public void setTrip(List<Trip> trip) {
		this.trip = trip;
	}

}
