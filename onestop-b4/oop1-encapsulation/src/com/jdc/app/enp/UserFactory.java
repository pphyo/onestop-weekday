package com.jdc.app.enp;

public class UserFactory {
	
	public static User withName(String name) {
		User user = new User();
		user.name = name;
		return user;
	}
	
	public static User withAge(int age) {
		User user = new User();
		user.age = age;
		return user;
	}

}
