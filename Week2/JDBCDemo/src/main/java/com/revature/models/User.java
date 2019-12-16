package com.revature.models;

import java.util.Objects;

public class User {

	private int id;
	private String username;
	private int hashedpassword;
	private String first_name;
	private String last;
	
	public User() {
		super();
	}

	public User(int id, String username, int hashedpassword, String first_name, String last) {
		super();
		this.id = id;
		this.username = username;
		this.hashedpassword = hashedpassword;
		this.first_name = first_name;
		this.last = last;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getHashedpassword() {
		return hashedpassword;
	}

	public void setHashedpassword(int hashedpassword) {
		this.hashedpassword = hashedpassword;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + hashedpassword;
		result = prime * result + id;
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
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
		if (first_name == null) {
			if (other.first_name != null) {
				return false;
			}
		} else if (!first_name.equals(other.first_name)) {
			return false;
		}
		if (hashedpassword != other.hashedpassword) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (last == null) {
			if (other.last != null) {
				return false;
			}
		} else if (!last.equals(other.last)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", hashedpassword=" + hashedpassword + ", first_name="
				+ first_name + ", last=" + last + "]";
	}
}
