package com.jdc.enm;

// public final class Day extends Enum<> {}

public enum Day {
	
	SUN("Sunday"), 
	MON("Monday"), 
	TUE("Tuesday"), 
	WED("Wednesday"), 
	THU("Thursday"), 
	FRI("Friday"), 
	SAT("Saturday");
	
	private String title;
	
	Day(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

}
