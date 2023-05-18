package com.jdc.app;

public class Student implements Comparable<Student> {

	private String name;
	private int age;
	private int marks;

	public Student(String name, int age, int marks) {
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getMarks() {
		return marks;
	}

	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.getName());
	}
	
}
