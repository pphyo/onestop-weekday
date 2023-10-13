package com.jdc.inherit;

public class InheritApp {

	public static void main(String[] args) {
		
//		Duck duck = new Duck();
//		
//		Dog dog = new Dog("");
//		
//		Animal animal = new Animal();
//		
//		animal.eat("Something");
//		
//		animal = duck;
//		
//		animal.eat("Weed");
//		
//		animal = dog;
//		
//		animal.eat("Beef");
		
		Animal ani = new Dog();

		System.out.println(ani instanceof Object);
		
		if(ani instanceof Duck duck) {
			duck.goose();
		}
		
	}

}








