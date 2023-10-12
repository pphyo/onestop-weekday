package com.jdc.inherit;

public class Animal {
	
	private String color;
	private double weight;
	private int age;
	private String species;
	
	{
		System.out.println("Animal Instance Block");
	}
	
	public Animal(String species) {
		super();
		System.out.println("Animal Constructor");
		System.out.println(color);
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
		
	}

}






