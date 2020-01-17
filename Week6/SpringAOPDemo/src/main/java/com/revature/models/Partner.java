package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Partner implements Serializable {

	private static final long serialVersionUID = -1012070742525634970L;

	private int id;
	private String name;
	
	@Autowired
	private Digimon buddy;

	public Partner() {
		super();
	}

	public Partner(int id, String name, Digimon buddy) {
		super();
		this.id = id;
		this.name = name;
		this.buddy = buddy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Digimon getBuddy() {
		return buddy;
	}

	public void setBuddy(Digimon buddy) {
		this.buddy = buddy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(buddy, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Partner)) {
			return false;
		}
		Partner other = (Partner) obj;
		return Objects.equals(buddy, other.buddy) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Partner [id=" + id + ", name=" + name + ", buddy=" + buddy + "]";
	}
}
