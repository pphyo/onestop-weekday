package com.jdc.abst;

// all the things the classes can do

abstract public class Animal {

	public final static int ID = 1;
	private String color;
	
	{
		System.out.println("Instance Block");
	}
	
	static {
		System.out.println("Static Block");
	}

	public Animal(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
	abstract void eat(String food);

}
