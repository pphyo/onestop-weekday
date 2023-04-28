package com.jdc.app;

public class CompositionApp {

	public static void main(String[] args) {
		
//		Engine engine = new Engine(3000, "Ford");
//		Car car = new Car("Honda", "Fit", new Engine(3000, "Ford"));
		
		Person person = new Person("Bruno", "093929292", new Car("Honda", "Fit", new Engine(3000, "Ford")));
		
		person.drive();
		
		System.out.println("Car Model: " + person.getCar().getModel());
		System.out.println("Horse Power: " + person.getCar().getEngine().getHp());
	}

}
