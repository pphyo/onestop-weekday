package com.jdc.composition;

public class Engine {

	private String model;
	private double hp;
	
	public void start() {
		System.out.println("Engine is starting...");
	}
	
	public void stop() {
		System.out.println("Engine is stopped...");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

}
