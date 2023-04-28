package com.jdc.abst;

public class AbstractionApp {

	public static void main(String[] args) {
		
		Animal goatKyar = new Dog("Yellow");
		
		System.out.println(goatKyar);
		goatKyar.eat("Steak");
		
		Animal alpha = new Wolf("Grey");
		alpha.eat("deer");
		
		// Anonymous inner class
		Animal shweWah = new Animal("Gold") {
			@Override
			void eat(String food) {
				System.out.println("Fish eats " + food);
			}
		};
		
		shweWah.eat("seaweeds");
		
		Animal shweGal = new Animal("Green") {
			@Override
			void eat(String food) {
				System.out.println("Bird eats " + food);
			}
		};
		
		shweGal.eat("sunflower seeds");

	}

}
