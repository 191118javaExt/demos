package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

public class Season implements Serializable {

	private static final long serialVersionUID = -8396286462022865210L;

	private String name;
	private double minTemp;
	private double averageTemp;
	private double maxTemp;
	private int humidity;
	private double dewPoint;
	
	public Season() {
		super();
	}

	public Season(String name, double minTemp, double averageTemp, double maxTemp, int humidity, double dewPoint) {
		super();
		this.name = name;
		this.minTemp = minTemp;
		this.averageTemp = averageTemp;
		this.maxTemp = maxTemp;
		this.humidity = humidity;
		this.dewPoint = dewPoint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}

	public double getAverageTemp() {
		return averageTemp;
	}

	public void setAverageTemp(double averageTemp) {
		this.averageTemp = averageTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(double dewPoint) {
		this.dewPoint = dewPoint;
	}

	@Override
	public int hashCode() {
		return Objects.hash(averageTemp, dewPoint, humidity, maxTemp, minTemp, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Season)) {
			return false;
		}
		Season other = (Season) obj;
		return Double.doubleToLongBits(averageTemp) == Double.doubleToLongBits(other.averageTemp)
				&& Double.doubleToLongBits(dewPoint) == Double.doubleToLongBits(other.dewPoint)
				&& humidity == other.humidity
				&& Double.doubleToLongBits(maxTemp) == Double.doubleToLongBits(other.maxTemp)
				&& Double.doubleToLongBits(minTemp) == Double.doubleToLongBits(other.minTemp)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Season [name=" + name + ", minTemp=" + minTemp + ", averageTemp=" + averageTemp + ", maxTemp=" + maxTemp
				+ ", humidity=" + humidity + ", dewPoint=" + dewPoint + "]";
	}
}
