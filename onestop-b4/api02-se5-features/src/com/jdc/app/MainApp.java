package com.jdc.app;

import static com.jdc.app.util.User.age;
import static com.jdc.app.util.User.getAge;

import java.util.Arrays;

public class MainApp {

	public static void main(String... args) {
		
//		System.out.println(new MainApp());
//		System.out.println(new MainApp[0]);
//		System.out.println(args);
//		System.out.println(new int[0]);
//		System.out.println(new double[0]);
//		showData();
		
		showArray(new int[] {1, 2, 3, 4});
		
		showVarargs("");
		
		showVarargs("", new int[] {2, 3, 4, 5});

	}
	
	static void showArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	static void showVarargs(String message, int... var) {
		System.out.println(Arrays.toString(var));
	}
	
	static void staticImport() {
		System.out.println(age);
		System.out.println(getAge());
	}
	
	static void autoBoxUnbox() {
		Integer objInt = Integer.valueOf(10);
		int priInt = 20;
		
		priInt = objInt; // Auto Unboxing
		objInt = priInt; // Auto Boxing
		
		Double objDou = Double.valueOf(100.0);
		double priDou = 200.0;
		
		objDou = priDou; // Auto Boxing
		priDou = objDou; // Auto Unboxing
		
//		objDou = priInt; // error
	}

}
