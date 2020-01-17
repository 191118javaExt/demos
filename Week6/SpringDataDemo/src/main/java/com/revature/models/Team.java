package com.revature.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "team")
public class Team implements Serializable {

	private static final long serialVersionUID = 5112769309047100055L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private int id;
	
	@Column
	private String type;
	
	@Column
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<User> members;

	public Team() {
		super();
	}

	public Team(int id, String type, String name, Set<User> members) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.members = members;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, members, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Team)) {
			return false;
		}
		Team other = (Team) obj;
		return id == other.id && Objects.equals(members, other.members) && Objects.equals(name, other.name)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", type=" + type + ", name=" + name + ", members=" + members + "]";
	}
}
