package com.revature.beans;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Account implements Serializable {

	private static final long serialVersionUID = -498284351838735069L;

	private double amount;

	public Account() {
		super();
	}

	public Account(double amount) {
		super();
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount);
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + "]";
	}
}
