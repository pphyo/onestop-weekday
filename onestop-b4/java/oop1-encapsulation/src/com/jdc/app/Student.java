package com.jdc.app;

public class Student {
	
	private String name;
	private int age = 1;
	
	{
		System.out.println("Instance Block");
	}
	
	public Student() {
		super();
		System.out.println("Default");
		int code = hashCode();
		System.out.println(code);
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// setter or mutator
	public void setAge(int outAge) {
		if(outAge > 0)
			age = outAge;
	}
	
	// getter or accessor
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return this.age;
	}

}






