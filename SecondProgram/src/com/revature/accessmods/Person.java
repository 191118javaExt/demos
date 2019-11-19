package com.revature.accessmods;

public class Person {

	private int age;
	private String name;
	
	public Person() {
		super();
	}
	
	public Person(int age2, String name2) {
		super();
		age = age2;
		name = name2;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int value) {
		if(value < 0) {
			System.out.println("Age cannot be negative");
		} else {
			age = value;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name2) {
		// null means that the reference variable
		// does not point to any valid memory address
		if(name2 == null) {
			System.out.println("Name cannot be null");
		} else if(name2.equals("")) {
			System.out.println("Name should not be empty");
		} else {
			name = name2;
		}
	}
}
