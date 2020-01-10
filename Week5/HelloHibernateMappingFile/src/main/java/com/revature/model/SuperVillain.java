package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * I think we can do it, TWO SCOOPS - NEEL 2020
 */
/*@Entity
@Table(name="Super_Villain")*/
public class SuperVillain {
	
	/*
	 * @Id
	 * 
	 * @Column(name="svill_id")
	 * 
	 * @GeneratedValue(strategy=GenerationType.AUTO)
	 */
	private int svillId;
	
	/* @Column(name="name", unique=true, nullable=false) */
	private String name;
	
	/* @Column(name="superpower") */
	private String superpower;
	
	/* @Column(name="bounty") */
	private int bounty;
	

	public SuperVillain() {
		
	}
	
	
	
	public SuperVillain(int svillId, String name, String superpower, int bounty) {
		this.svillId = svillId;
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
		
	}

	


	public SuperVillain(String name, String superpower, int bounty) {
		super();
		this.name = name;
		this.superpower = superpower;
		this.bounty = bounty;
	}



	



	public int getSvillId() {
		return svillId;
	}

	public void setSvillId(int svillId) {
		this.svillId = svillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperpower() {
		return superpower;
	}

	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}

	public int getBounty() {
		return bounty;
	}

	public void setBounty(int bounty) {
		this.bounty = bounty;
	}




	@Override
	public String toString() {
		return "SuperVillain [svillId=" + svillId + ", name=" + name + ", superpower=" + superpower + ", bounty="
				+ bounty +  "]";
	}



	



}
	
	
	
	

