package com.jdc.abstraction;

public interface CanSwim {

	public static final int i = 10;
	
	void swim();
	
	default void def() {
		
	}
	
	static void stat() {
		
	}
}
