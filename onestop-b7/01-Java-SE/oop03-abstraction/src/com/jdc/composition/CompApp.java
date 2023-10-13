package com.jdc.composition;

public class CompApp {

	public static void main(String[] args) {
		
		var engine = new Engine();
		
		var car = new Car();
		car.setEngine(engine);
		
		var person = new Person();
		person.setCar(car);
		
		person.drive();

	}

}
