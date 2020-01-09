package com.reavture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Crime")
public class Crimes {
	
	@Id
	@Column(name="crime_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int crimeId;
	
	@Column(name="crime_name",nullable=false,unique=true)
	private String crimeName;
	
	@Column(name= "description")
	private String description;
	
	public Crimes() {
		
	}

	public Crimes(int crimeId, String crimeName, String description) {
		super();
		this.crimeId = crimeId;
		this.crimeName = crimeName;
		this.description = description;
	}

	public Crimes(String crimeName, String description) {
		super();
		this.crimeName = crimeName;
		this.description = description;
	}

	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public String getCrimeName() {
		return crimeName;
	}

	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Crimes [crimeId=" + crimeId + ", crimeName=" + crimeName + ", description=" + description + "]";
	}
	
	

}
