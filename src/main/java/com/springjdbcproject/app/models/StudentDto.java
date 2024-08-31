package com.springjdbcproject.app.models;

public class StudentDto {
	private int rollNum;
	private String name;
	private int marks;

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(int rollNum, String name, int marks) {
		super();
		this.rollNum = rollNum;
		this.name = name;
		this.marks = marks;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "StudentDto [rollNum=" + rollNum + ", name=" + name + ", marks=" + marks + "]";
	}
	
}
