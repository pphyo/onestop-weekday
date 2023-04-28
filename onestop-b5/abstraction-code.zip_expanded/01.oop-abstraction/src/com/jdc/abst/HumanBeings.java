package com.jdc.abst;

public class HumanBeings {
	
	private Pet pet;
	
	public HumanBeings() {
		pet = new Dog("Black");
	}
	
	public void feedingFood() {
		pet.askForFood();
	}

}
