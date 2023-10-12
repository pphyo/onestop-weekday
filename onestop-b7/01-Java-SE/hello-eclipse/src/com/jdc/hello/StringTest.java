package com.jdc.hello;

public class StringTest {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		
		String s2 = "Hello";
		
		String s3 = new String("Hello");
		
		System.out.println("s1 == s2 " + (s1 == s2));
		
		System.out.println("s1 == s3 " + (s1 == s3));
		
		System.out.println("s1.equals(s3) " + s1.equals(s3));
		
		System.out.println(s1 = s1.concat(" Hayabusa"));
		
		System.out.println("s1 == s2 " + (s1 == s2));
		
		System.out.println();
		
		String str1 = "Hello World";
		
		String str2 = "  Hello World".trim();
		
		System.out.println(str1 == str2);
		
		System.out.println();
		
		String text1 = "Get your freedom";
		
		String text2 = " you deserve";
		
		String text3 = "Get your freedom you deserve";
		
		text1 += text2;
		
		System.out.println(text1);
		System.out.println(text1 == text2);
		System.out.println(text1 == text3);
		System.out.println(text2 == text3);
		
		System.out.println();
		
		String value1 = "S" + "O" + "L" + "T";
		String value2 = "SOL" + "T";
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value1 == value2);

	}
	
}







