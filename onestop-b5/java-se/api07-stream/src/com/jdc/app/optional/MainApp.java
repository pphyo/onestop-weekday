package com.jdc.app.optional;

import java.util.Optional;

public class MainApp {

	public static void main(String[] args) {
		
//		var person = new Person();
//		var name = person.getCarInsuranceName();
//		
//		System.out.println(name);
		
		String name = getCarInsuranceName(new Person());
		System.out.println(name);
		
		Optional<String> opt = Optional.ofNullable("Arrow");
		
		opt.ifPresentOrElse(value -> {
			System.out.println(value.substring(2));
		}, () -> System.out.println("Other"));

	}
	
	static String getCarInsuranceName(Person person) {
		Optional<Person> optPerson = Optional.of(person);
		
		Optional<Optional<Car>> optCar = optPerson.map(p -> p.getCar());
		
		Optional<Insurance> optInsu = optCar.flatMap(car -> Optional.of(new Insurance("Tokyo")));
		
		Optional<String> result = optInsu.map(insu -> insu.getName());

		return result.orElse("Capital Tokyo");
		
	}

}
