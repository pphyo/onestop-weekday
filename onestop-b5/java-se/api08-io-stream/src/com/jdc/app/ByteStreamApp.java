package com.jdc.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamApp {

	public static void main(String[] args) {
		
		try(var in = new FileInputStream("img.jpg");
				var out = new FileOutputStream("copy.jpg")) {
			
			int data;
			
			while(-1 != (data = in.read())) {
				out.write(data);
				System.out.print((char)data);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
