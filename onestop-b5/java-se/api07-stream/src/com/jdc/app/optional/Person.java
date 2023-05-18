package com.jdc.app.optional;

import java.util.Optional;

public class Person {
	
	private Optional<Car> car;

	public Optional<Car> getCar() {
		return car;
	}
	
	public Object getCarInsuranceName() {
//		if(null == car) {
//			return "Unknown";
//		}
//		
//		var insu = car.getInsurance();
//		
//		if(null == insu) {
//			return "Unknown";
//		}
//		Car c = new Car();
//		car = Optional.ofNullable(null);
		
		return car;
		
	}

}
