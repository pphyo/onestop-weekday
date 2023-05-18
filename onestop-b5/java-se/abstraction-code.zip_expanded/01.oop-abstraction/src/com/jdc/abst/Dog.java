package com.jdc.abst;

public class Dog extends Animal implements Pet {

	public Dog(String color) {
		super(color);
	}
	
	@Override
	public void eat(String meal) {
		System.out.println("Dog eats %s".formatted(meal));
	}

	@Override
	public void askForFood() {
		
	}
	
}
