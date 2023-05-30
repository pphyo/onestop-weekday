package com.jdc.inherit;

public class Student extends Person {
	
	private int totalMark;
	private String stuId;

	public Student() {
		super("Mg Mg");
		System.out.println("Student Default Const...");
	}
	
	public Student(String name) {
		super(name);
		System.out.println("1 arg constructor");
	}
	
	public Student(String name, int totalMark) {
		this(name);
		this.totalMark = totalMark;
		System.out.println("2 args constructor");
	}
	
	public Student(String name, int totalMark, String stuId) {
		this(name, totalMark);
		this.stuId = stuId;
		System.out.println("3 args constructor");
	}
	
	public static void showCount() {
		System.out.println("Person Count...");
	}

	public int getTotalMark() {
		return totalMark;
	}

	public String getStuId() {
		return stuId;
	}

}






