package com.jdc.excep;

public class ExceptionApp {
	
	public static void main(String[] args) {
		
		System.out.println("Started...");
		
		methodOne(); // call task
		
		System.out.println("Terminated...");
		
	}
	
	static void methodOne() {
		methodTwo();
		System.out.println("methodOne()");
	}
	
	static void methodTwo() {
		try {
		} catch (Exception e) {
			System.err.println("Hello Thread");
		}
		System.out.println("methodTwo()");
	}
	
	static void methodThree() throws InterruptedException {
		System.out.println("Before thread");
		Thread.sleep(1000);
//		System.out.println(3 / 0);
		System.out.println("After thread");
	}

}
