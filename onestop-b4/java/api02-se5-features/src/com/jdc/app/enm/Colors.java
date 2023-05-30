package com.jdc.app.enm;

public enum Colors {
	
	WHITE("White"),
	BLACK("Black"),
	BLUE("Blue"),
	GREEN("Green"),
	RED("Red"),
	PURPLE("Purple"),
	INDIGO("Indigo");
	
	private String name;
	
	Colors(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}





