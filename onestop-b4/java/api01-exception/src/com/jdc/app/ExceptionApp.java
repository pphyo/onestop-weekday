package com.jdc.app;

public class ExceptionApp {
	
	private String data = "Nana";

	public static void main(String[] args) {
		
		assert 4 < 5;
		
		System.out.println("Program start.");

		try {
			methodOne();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Program terminate.");
		
	}
	
	static void methodOne() throws CloneNotSupportedException {
//		methodTwo();
		
		ExceptionApp app = new ExceptionApp();
		Object obj = app.copy();
		String text = ((ExceptionApp)obj).data;
		
		System.out.println(text);
	}
	
	static void methodTwo() {
		methodThree();
	}
	
	static void methodThree() {
		methodFour();
	}
	
	static void methodFour() {
		String str = null;
		
		System.out.println(str.charAt(0));
	}
	
	Object copy() throws CloneNotSupportedException {
		return this.clone();
	}

}






