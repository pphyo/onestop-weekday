package com.jdc.proto;

public class PrototypeApp {
	
	public static void main(String[] args) {
		
		Shape rect = new Rectangle(10, 20);
		Shape rectClone = rect.clone(20, 30);
		
		System.out.printf("%s%n%s%n", rect, rectClone);
		
		Shape sq = new Square(12);
		Shape sqClone = sq.clone(13, 13);
		
		System.out.printf("%s%n%s%n", sq, sqClone);
	}

}
