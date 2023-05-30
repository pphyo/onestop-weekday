package com.jdc.app;

public class RideLoadApp {

	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		C c = new C();
		
		a = b;
		b = c;
		a.run();
		
		RideLoadApp app =  new RideLoadApp();
		app.overload(b);
		

	}
	
	public void overload(A a) {
		System.out.println("A version.");
	}
	
	public void overload(B b) {
		System.out.println("B version.");
	}
	
	public void overload(C c) {
		System.out.println("C version.");
	}

}

class A {
	public void run() {
		System.out.println("A runs.");
	}
}

class B extends A {
	public void run() {
		System.out.println("B runs.");
	}
}

class C extends B {
	public void run() {
		System.out.println("C runs.");
	}
}





