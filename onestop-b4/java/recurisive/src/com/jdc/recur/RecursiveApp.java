package com.jdc.recur;

public class RecursiveApp {

	public static void main(String[] args) {
		int num = 4;
		System.out.println("Factorial number of " + num + " is " + factorial(num));
	}

	public static int factorial(int num) {
		if(num > 1)
			return num * factorial(num - 1);
		
		System.out.println(num);
		return num;
	}

}
