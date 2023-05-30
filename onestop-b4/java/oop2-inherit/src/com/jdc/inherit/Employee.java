package com.jdc.inherit;

public class Employee extends Person {
	
	public int count = 20;

	public Employee(String name) {
		super(name);
	}
	
	public static void showCount() {
		System.out.println("Employee Count...");
	}


	public void showName() {
		System.out.println("Name: " + getName());
	}
	
	public void work(int hour) {
		System.out.printf("Employee works for %d %s%n.", hour, hour == 1 ? "hour" : "hours");
	}
	
	@Override
	public void eat(String food) {
		System.out.println("Hand wash before eating...");
		System.out.println("Employee eats " + food);
		System.out.println("Wash Plate");
	}
	
	@Override
	public long getCount() {
		return super.count;
	}
	
	// covaninent return type
	@Override
	public Student getObject() {
		return new Student();
	}
}



