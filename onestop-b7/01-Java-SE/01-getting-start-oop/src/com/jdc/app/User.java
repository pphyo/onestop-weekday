package com.jdc.app;

public class User {
	
	private String name;
	private int age;
	private String phone;

	public User() {
		System.out.println("User Default Constructor");
	}
	
	public String getName() {
		return name;
	}
	
	// mutator or setter
	public void setName(String outName) {
		name = outName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int outAge) {
		if(outAge <= 10) {
			throw new IllegalArgumentException("Age must be greater than 10.");
		}
		age = outAge;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String outPhone) {
		phone = outPhone;
	}

}










