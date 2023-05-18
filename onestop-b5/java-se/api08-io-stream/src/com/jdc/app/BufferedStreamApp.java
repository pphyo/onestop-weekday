package com.jdc.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStreamApp {

	public static void main(String[] args) {
		
		try(var in = new BufferedReader(new FileReader("data.txt"));
				var out = new BufferedWriter(new FileWriter("out.txt"))) {
			
			String line;
			
			while(null != (line = in.readLine())) {
				out.write(line);
				System.out.println(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
