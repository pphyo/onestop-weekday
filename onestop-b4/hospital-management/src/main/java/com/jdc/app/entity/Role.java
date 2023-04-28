package com.jdc.app.entity;

public enum Role {
	Head_Doctor("Head Doctor"), 
	Doctor("Doctor"), 
	Assitance_Doctor("Assitance Doctor"), 
	Nurse("Nurse"),
	Pharmacy("Pharmacy");
	
	private String name;
	
	private Role(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
