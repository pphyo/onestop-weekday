package com.jdc.app.enm;

import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings({"unused", "serial"})
public class UsingEnum implements Serializable {
	
	private int i;

	public static void main(String[] args) {
		printColour(Colors.WHITE);
		
		System.out.println(Colors.BLACK.ordinal());
		
		System.out.println(Colors.valueOf("WHITE"));
		
		System.out.println(Arrays.toString(Colors.values()));
	}
	
	static void printColour(Colors color) {
		System.out.println(color);
	}

}
