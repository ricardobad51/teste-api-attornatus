package com.belemburitiricardo.api.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.belemburitiricardo.api.entities.Person;

public class PersonDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Instant birthDate;
	
	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}{}
	
	public PersonDTO(Long id, String name, Instant birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public PersonDTO(Person entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.birthDate = entity.getBirthDate();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

}
