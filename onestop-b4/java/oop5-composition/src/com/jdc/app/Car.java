package com.jdc.app;

public class Car {

	private String company;
	private String model;
	private Engine engine;

	public Car(String company, String model, Engine engine) {
		this.company = company;
		this.model = model;
		this.engine = engine;
	}

	public String getCompany() {
		return company;
	}

	public String getModel() {
		return model;
	}

	public Engine getEngine() {
		return engine;
	}

	public void move() {
		engine.start();
		System.out.println("Car is moving");
	}

}
