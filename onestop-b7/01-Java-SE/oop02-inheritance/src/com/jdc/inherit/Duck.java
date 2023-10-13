package com.jdc.inherit;

public class Duck extends Animal {
	
	public String name = "Kalayar";
	public int value = 30;
	
	public Duck() {
		super("Pet");
	}
	
	public void eat(String meat) {
		System.out.println("Duck eats %s".formatted(meat));
		logMessage();
	}
	
	@Override
	public void logMessage() {
		System.out.println("""
				Name: %s
				Value: %d
				""".formatted(name, value));
	}
	
	// Covariant return type
	@Override
	public MyGrandChildClass generateObject() {
		return null;
	}
	
	public void goose() {
		System.out.println("Duck gooses");
	}
	
}








