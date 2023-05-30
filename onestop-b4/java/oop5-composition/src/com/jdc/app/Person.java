package com.jdc.app;

public class Person {

	private String name;
	private String phone;
	private Car car; // has a or composition

	public Person(String name, String phone, Car car) {
		super();
		this.name = name;
		this.phone = phone;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public Car getCar() {
		return car;
	}
	
	public void drive() {
		car.move();
		System.out.println("Driving to the califonia");
	}

}
