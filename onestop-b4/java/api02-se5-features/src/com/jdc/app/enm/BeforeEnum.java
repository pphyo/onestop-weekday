package com.jdc.app.enm;

public class BeforeEnum {
	
	public static final int WHITE = 1;
	public static final int BLACK = 2;
	public static final int GREEN = 3;
	public static final int YELLOW = 4;
	public static final int BLUE = 5;

	public static void main(String[] args) {
		
		printColour(WHITE);

	}
	
	static void printColour(final int code) {
		
		switch(code) {
		case 1:
			System.out.println("White");
			break;
		case 2:
			System.out.println("Black");
			break;
		case 3:
			System.out.println("Green");
			break;
		case 4:
			System.out.println("Yellow");
			break;
		case 5:
			System.out.println("Blue");
			break;
		default:
			System.out.println("Wrong Code");
		}
	}

}
