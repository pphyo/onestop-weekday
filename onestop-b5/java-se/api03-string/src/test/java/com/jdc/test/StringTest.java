package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringTest {
	
	@Test
	void test_for_mutable_string() {
		
		var sb = new StringBuilder();
		sb.append("Good Things");
		System.out.println(sb);
		System.out.println("Capacity: " + sb.capacity());
		System.out.println("Length: " + sb.length());
		System.out.println();

		sb.append(" Shoudn't be us");
		System.out.println(sb);
		System.out.println("Capacity: " + sb.capacity()); // (capicity + 1) * 2
		System.out.println("Length: " + sb.length());
		System.out.println();
		
		sb.append("Where have you been?");
		System.out.println(sb);
		System.out.println("Capacity: " + sb.capacity()); // (capicity + 1) * 2
		System.out.println("Length: " + sb.length());
		System.out.println();
	}
	
	@Test
	void test() {
		
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		
		assertTrue(s1 == s2);
		assertFalse(s2 == s3);
		assertTrue(s2.equals(s3));
		
		assertSame(s1, s2);
		assertNotSame(s1, s3);
		
		s1 = s1.concat(" Nilar");
		
		assertEquals("Hello Nilar", s1);
		
	}

}
