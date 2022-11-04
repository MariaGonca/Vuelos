package com.solera.ndproyect.ndproyect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="places")
public class Place {

	@Id
	@Column(name = "ID_PLACE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPlace;
	
	@Column(name = "NAME", unique=true)
	@NotNull
	@NotEmpty
	private String name;
	
	public Place(String name) {
		this.name = name;
	}

	public Place() {
	}

	
	public Place(Long idPlace, String name) {
		this.idPlace = idPlace;
		this.name = name;
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

	

	@Override
	public String toString() {
		return "Place [idPlace=" + idPlace + ", name=" + name + "]";
	}

}
