package com.jdc.inherit;

import java.io.IOException;

public class Person {
	
	private String name;
	public int count = 10;
	
//	public Person() {
//		super();
//		System.out.println("Person Default Const...");
//	}
	
	public Person(String name) {
		super();
		this.name = name;
		System.out.println("Person name const...");
	}
	
	public static void showCount() {
		System.out.println("Person Count...");
	}
	
	public String getName() {
		return name;
	}
	
	void eat(String food) throws IOException {
		System.out.println("Person eats " + food);
	}
	
	public long getCount() {
		return count;
	}
	
	public Person getObject() {
		return this;
	}

}




