package com.jdc.col;

public class Student implements Comparable<Student> {

	private String name;
	private int age;
	private char grade;

	public Student(String name, int age, char grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public char getGrade() {
		return grade;
	}
	
	public String toString() {
		return """
				Name: %s, Age: %d, Grade: %s
				""".formatted(name, age, grade);
	}
	
	@Override
	public int compareTo(Student o) {
		return o.name.compareTo(name);
	}

}
