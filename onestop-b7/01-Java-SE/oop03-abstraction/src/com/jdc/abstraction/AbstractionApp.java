package com.jdc.abstraction;

interface MyInterOne {

	void perform();

	default void show() {
		System.out.println("MyInterOne show()");
	}

	static void output() {
		System.out.println("MyInterOne output()");
	}

}

interface MyInterTwo {
	void perform();

	default void show() {
		System.out.println();
	}

}

interface MyInterThree extends MyInterOne, MyInterTwo {

	@Override
	default void show() {
		MyInterOne.super.show();
	}

}

public class AbstractionApp implements MyInterOne {

	@Override
	public void perform() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		MyInterOne.super.show();
	}

	public static void main(String[] args) {

		// anonymous inner class
		Animal animal = new Animal() {

			@Override
			public void move() {
				System.out.println("Animal moves");
			}
			
		};
		animal.move();
	
//		Animal ani = new Panda();
//		ani.move();


		CanSwim tiger = new Tiger();

		tiger.swim();

	}

}
