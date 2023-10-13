package com.jdc.abstraction;

public abstract class Animal {
	
	private String name;
	public static final int CODE = 10;
	
	{
		System.out.println("Instance block");
	}
	
	static {
		System.out.println("Static block");
	}
	
	public Animal() {
		System.out.println("Animal Constructor");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void move();

}







