package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "users")
@Component
public class User implements Serializable {

	private static final long serialVersionUID = -4553508689874995351L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_friends",
				joinColumns = {@JoinColumn(name = "source_id", referencedColumnName = "user_id")},
				inverseJoinColumns = {@JoinColumn(name = "target_id", referencedColumnName = "user_id")})
	private List<User> friends;

	public User() {
		super();
	}
	
	public User(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.friends = new ArrayList<>();
	}

	public User(int id, String firstName, String lastName, List<User> friends) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.friends = friends;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	public boolean addFriend(User u) {
		if(!this.friends.contains(u) && !u.friends.contains(this)) {
			this.friends.add(u);
			return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, friends, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(friends, other.friends) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", friends=" + friends + "]";
	}
}
