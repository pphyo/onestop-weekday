package com.jdc.app;

import java.io.FileReader;
import java.io.FileWriter;

public class CharacterStreamApp {

	public static void main(String[] args) {
		
		try(var in = new FileReader("img.jpg");
				var out = new FileWriter("copy.jpg")) {
			
			int data;
			
			while(-1 != (data = in.read()))
				out.write(data);
			
			System.out.println("Program Complete");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
