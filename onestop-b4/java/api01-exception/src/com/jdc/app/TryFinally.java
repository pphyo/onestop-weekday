package com.jdc.app;

import java.util.Scanner;

public class TryFinally {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			
		} finally {
			sc.close();
		}
		
		try {
			
			int i = 10;
			
			if(i % 2 == 10)
				return;
			
			System.out.println(3 / 0);
		} catch(ArithmeticException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Program end.");
		}

	}

}
