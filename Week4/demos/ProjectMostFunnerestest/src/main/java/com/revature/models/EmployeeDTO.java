package com.revature.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 7888951469121413987L;
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	private String hireDate;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(int id, String firstName, String lastName, String username, String password, String hireDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.hireDate = hireDate;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, hireDate, id, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EmployeeDTO)) {
			return false;
		}
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(hireDate, other.hireDate) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", hireDate=" + hireDate + "]";
	}
}
