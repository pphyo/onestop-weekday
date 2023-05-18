package com.jdc.varargs;

public class VarargsApp {

	public static void main(String... args) {
		
		// ... 0 or More
		
		Data data = new Data();
		System.out.println(data.getClass().getSuperclass());
		
		Data[] datas = new Data[0];
		System.out.println(datas.getClass().getSimpleName());
		
		printVarargs(10);
		
	}
	
	public static void printVarargs(int i, String... data) {
		System.out.println(data);
	}
	
	public static void printArray(String[] arr) {}

}
