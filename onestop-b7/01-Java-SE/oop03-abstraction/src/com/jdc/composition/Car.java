package com.jdc.composition;

public class Car {

	private String model;
	private String year;
	private int door;
	private int wheel;
	
	private Engine engine;
	
	public void move() {
		engine.start();
		System.out.println("Car is moving...");
	}
	
	public void stop() {
		engine.stop();
	}

	public String getModel() {
		return model;
	}

	public String getYear() {
		return year;
	}

	public int getDoor() {
		return door;
	}

	public int getWheel() {
		return wheel;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

}
