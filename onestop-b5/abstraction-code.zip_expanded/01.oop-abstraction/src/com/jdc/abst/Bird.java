package com.jdc.abst;

public class Bird extends Animal implements Flyable {

	public Bird(String color) {
		super(color);
	}

	@Override
	public void fly() {
		
	}

	@Override
	void eat(String food) {
		
	}

}
