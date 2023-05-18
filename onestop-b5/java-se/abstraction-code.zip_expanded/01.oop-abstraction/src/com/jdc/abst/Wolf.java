package com.jdc.abst;

public class Wolf extends Canine {

	public Wolf(String color) {
		super(color);
	}
	
	@Override
	public void eat(String food) {
		System.out.println("Wolf eats " + food);
	}

}
