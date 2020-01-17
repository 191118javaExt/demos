package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Digimon implements Serializable {

	private static final long serialVersionUID = 788852839658494542L;

	private int id;
	private String name;
	private String type;
	private String evolutionLevel;
	
	public Digimon() {
		super();
	}

	public Digimon(int id, String name, String type, String evolutionLevel) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.evolutionLevel = evolutionLevel;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEvolutionLevel() {
		return evolutionLevel;
	}

	public void setEvolutionLevel(String evolutionLevel) {
		this.evolutionLevel = evolutionLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(evolutionLevel, id, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Digimon)) {
			return false;
		}
		Digimon other = (Digimon) obj;
		return Objects.equals(evolutionLevel, other.evolutionLevel) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Digimon [id=" + id + ", name=" + name + ", type=" + type + ", evolutionLevel=" + evolutionLevel + "]";
	}
}
