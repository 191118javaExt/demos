package com.reavture.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Super_Prison")
public class SuperPrisons {
	
	@Id
	@Column(name="spid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int spid;
	
	@Column(name="sp_name")
	private String spName;
	
	@Column(name="sp_location")
	private String location;
	
	@OneToMany(mappedBy="superPrisonHolder", fetch=FetchType.LAZY)
	private List<SuperVillain> villList = new ArrayList<SuperVillain>();
	
	
	public SuperPrisons() {
		
	}


	public SuperPrisons(int spid, String spName, String location, List<SuperVillain> villList) {
		super();
		this.spid = spid;
		this.spName = spName;
		this.location = location;
		this.villList = villList;
	}


	public SuperPrisons(String spName, String location, List<SuperVillain> villList) {
		super();
		this.spName = spName;
		this.location = location;
		this.villList = villList;
	}


	public SuperPrisons(String spName, String location) {
		super();
		this.spName = spName;
		this.location = location;
	}


	public int getSpid() {
		return spid;
	}


	public void setSpid(int spid) {
		this.spid = spid;
	}


	public String getSpName() {
		return spName;
	}


	public void setSpName(String spName) {
		this.spName = spName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public List<SuperVillain> getVillList() {
		return villList;
	}


	public void setVillList(List<SuperVillain> villList) {
		this.villList = villList;
	}


	@Override
	public String toString() {
		return "SuperPrisons [spid=" + spid + ", spName=" + spName + ", location=" + location + ", villList=" + villList
				+ "]";
	}
	
	

}
