package com.revature.accessmods;

public class Student extends Person {
	
	private int studentId;
	private String major;

	public Student() {
		super();
	}
	
	public Student(int studentId, String major) {
		super();
		this.studentId = studentId;
		this.major = major;
	}
	
	public Student(int age, String name, int studentId, String major) {
		setAge(age);
		setName(name);
		this.studentId = studentId;
		this.major = major;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public void print() {
		System.out.println("age = " + getAge() + ", " +
			"name = " + getName() + ", studentId = " +
			getStudentId() + ", major = " + getMajor());
	}
}
