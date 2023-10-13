package com.jdc.inherit.overload;

import com.jdc.inherit.Animal;

public class OverloadApp {
	
	static final public synchronized void main(String[] args) {
		new Animal("Black", 30, 9, "Reptile");
	}
	
	// overload
	static void add(byte b) {
		System.out.println("byte");
	}
	
	static void add(short s) {
		System.out.println("short");
	}
	
	static void add(int i) {
		System.out.println("int");
	}
	
	static void add(long l) {
		System.out.println("long");
	}
	
	static void add(float f) {
		System.out.println("float");
	}
	
	static void add(double d) {
		System.out.println("double");
	}
	
	static void add(int a, int b) {}
	
	static void add(double a, double b) {}
	
	static void add(int a, double b) {}
	
	static void add(double a, int b) {}

}









