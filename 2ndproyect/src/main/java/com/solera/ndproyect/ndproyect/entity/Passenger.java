package com.solera.ndproyect.ndproyect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="passengers")
public class Passenger {
	
	@Id
	@Column(name = "ID_PASSENGER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPassenger;
	
	@Column(name = "NAME")
	@NotNull
	@NotEmpty
	private String name;
	
	@Column(name = "USERNAME")
	@NotNull
	@NotEmpty
	private String unsername;
	
	@Column(name = "NATIONALITY")
	@NotNull
	@NotEmpty
	private String nationality;
	
	@Column(name = "IDENTIFICATION")
	@NotNull
	@NotEmpty
	private String identification;
	
	@Column(name = "AGE")
	@NotNull
	@NotEmpty
	@Value("${some.key:9}")
	private int age;
	
	public Passenger(Long idPassenger, String name, String unsername, String nationality, String identification) {
		this.idPassenger = idPassenger;
		this.name = name;
		this.unsername = unsername;
		this.nationality = nationality;
		this.identification = identification;
	}

	public Passenger(Long idPassenger, String name, String unsername, String nationality, String identification,
			int age) {
		this.idPassenger = idPassenger;
		this.name = name;
		this.unsername = unsername;
		this.nationality = nationality;
		this.identification = identification;
		this.age = age;
	}

	public Passenger(String name, String unsername, String nationality, String identification, int age) {
		this.name = name;
		this.unsername = unsername;
		this.nationality = nationality;
		this.identification = identification;
		this.age = age;
	}

	public Passenger() {
	}

	public Long getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(Long idPassenger) {
		this.idPassenger = idPassenger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnsername() {
		return unsername;
	}

	public void setUnsername(String unsername) {
		this.unsername = unsername;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
