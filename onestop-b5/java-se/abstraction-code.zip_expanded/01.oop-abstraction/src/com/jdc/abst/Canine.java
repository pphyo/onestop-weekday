package com.jdc.abst;

public abstract class Canine extends Animal {

	public Canine(String color) {
		super(color);
	}
	
	@Override
	public void eat(String food) {
		System.out.println("Canine eats " + food);		
	}

}
