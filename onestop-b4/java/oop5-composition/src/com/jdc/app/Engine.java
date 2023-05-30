package com.jdc.app;

public class Engine {
	
	private int hp;
	private String model;
	
	public Engine(int hp, String model) {
		this.hp = hp;
		this.model = model;
	}
	
	public void start() {
		System.out.println("Engine started...");
	}
	
	public void stop() {
		System.out.println("Engine stopped...");
	}

	public int getHp() {
		return hp;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "Engine [hp=" + hp + ", model=" + model + "]";
	}

}
