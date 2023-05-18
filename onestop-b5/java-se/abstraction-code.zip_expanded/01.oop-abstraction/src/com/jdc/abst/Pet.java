package com.jdc.abst;

public interface Pet {
	
	void askForFood();
	
	public static void main(String[] args) {
		
		InterfaceTwo two = new InterfaceTwo() {
			
			@Override
			public void doOne() {
				System.out.println("doOne()");
			}
			
			@Override
			public void doTwo() {
				System.out.println("doTwo()");
			}
			
		};
		
		two.printData("No woman no cry.");
		
		System.out.println(InterfaceTwo.VALUE);
		
	}

}

interface InterfaceOne {
	
	int VALUE = 100;
	
	void doOne();
	
	static void doSomething() {
		
	}
	
	default void printData(String data) {
		System.out.println(data);
	}
	
}

interface InterfaceTwo extends InterfaceOne, InterfaceThree {
	
	void doTwo();

	@Override
	default void printData(String data) {
		InterfaceOne.super.printData(data);
	}
	
}

interface InterfaceThree {
	
	void doOne();
	
	default void printData(String data) {
		System.out.println(data);
	}
	
}