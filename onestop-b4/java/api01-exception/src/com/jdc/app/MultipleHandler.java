package com.jdc.app;

public class MultipleHandler {

	public static void main(String[] args) {
		
		try {
			
			System.out.println(new String[] {"Mg Mg", "Kyaw Kyaw"} [2]);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("AIOUBE");
		} catch (NullPointerException e) {
			System.out.println("NPE");
		} catch (RuntimeException e) {
			System.out.println("RE");
		} 

	}

}
