package com.solera.ndproyect.ndproyect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="airlines")
public class AirLine {

	@Id
	@Column(name = "ID_AIRLINE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAirLine;
	
	@Column(name = "NAME")
	@NotNull
	@NotEmpty
	private String name;
	
	@OneToOne(mappedBy = "airline")
	private Trip trip;
	
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

}
