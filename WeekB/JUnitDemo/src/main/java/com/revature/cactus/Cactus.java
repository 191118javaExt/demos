package com.revature.cactus;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cactus {

	private double height;
	private double waterStored;
	private String color;
	private List<Flower> flowers = new ArrayList<>();
	
	public Cactus() {
		super();
	}

	public Cactus(double height, double waterStored, String color) {
		super();
		this.height = height;
		this.waterStored = waterStored;
		this.color = color;
	}

	public Cactus(double height, double waterStored, String color, List<Flower> flowers) {
		super();
		this.height = height;
		this.waterStored = waterStored;
		this.color = color;
		this.flowers = flowers;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWaterStored() {
		return waterStored;
	}

	public void setWaterStored(double waterStored) {
		this.waterStored = waterStored;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}
	
	public void addFlower(Flower f) {
		flowers.add(f);
	}
	
	public Flower removeFlower(Flower f) {
		flowers.remove(f);
		return f;
	}
	
	public double grow(double rainfall) {
		if(rainfall < 0) {
			throw new IllegalArgumentException("Rainfall cannot be negative.");
		}
		
		height += 0.01 * rainfall;
		waterStored += .90 * rainfall;
		
		return height;
	}
	
	public int bloom() {
		System.out.println(flowers);
		return flowers.size();
	}
	
	public Cactus seeding() {
		List<Flower> flowers2 = new ArrayList<>(flowers);
		Collections.shuffle(flowers2);
		
		// Remove the right half of the flowers
		for(int i = 0; i < flowers.size() / 2; i++) {
			flowers2.remove(flowers2.size() - 1);
		}
		
		return new Cactus(0.01 * height, 0.01 * waterStored, color, flowers2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((flowers == null) ? 0 : flowers.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(waterStored);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cactus other = (Cactus) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (flowers == null) {
			if (other.flowers != null)
				return false;
		} else if (!flowers.equals(other.flowers))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(waterStored) != Double.doubleToLongBits(other.waterStored))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cactus [height=" + height + ", waterStored=" + waterStored + ", color=" + color + ", flowers=" + flowers
				+ "]";
	}
}
