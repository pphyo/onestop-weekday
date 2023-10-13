package com.jdc.inherit;

public class Animal {
	
	public static int code;
	public String name = "Wah Wah";
	public int value = 20;
	private String color;
	private double weight;
	private int age;
	private String species;
	
	{
		System.out.println("Animal Instance Block");
	}
	
	public Animal() {
		super();
		System.out.println("Animal default constructor...");
	}
	
	public Animal(String color) {
		super();
		this.color = color;
		System.out.println("1 arg constructor...");
	}
	
	public Animal(String color, double weight) {
		this(color);
		this.weight = weight;
		System.out.println("2 args constructor...");
	}
	
	public Animal(String color, double weight, int age) {
		this(color, weight);
		this.age = age;
		System.out.println("3 args constructor...");
	}
	
	public Animal(String color, double weight, int age, String species) {
		this(color, weight, age);
		this.species = species;
		System.out.println("4 args constructor...");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void eat(String meat) {
		System.out.println("Animal eats %s".formatted(meat));
		logMessage();
	}
	
	public void logMessage() {
		System.out.println("""
				Name: %s
				Value: %d
				""".formatted(name, value));
	}
	
	public MyChildClass generateObject() {
		return null;
	}
	
	public static void shift() {
		System.out.println("Static shift");
	}

}

class MyParentClass {}

class MyChildClass extends MyParentClass {}

class MyGrandChildClass extends MyChildClass {}










