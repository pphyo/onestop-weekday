package com.jdc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CollectionUtilityTest {
	
	@Test
	void test_for_sort() {
		var list = new ArrayList<Integer>();
		Collections.addAll(list, 2, 4, 6, 8, 10, 9, 7, 5, 3, 1);
		
	}
	
	@Test
	@Disabled
	void test() {
		
		var list = new ArrayList<Integer>();
		Collections.addAll(list, 2, 4, 6, 8, 10, 9, 7, 5, 3, 1);
		
		System.out.println("Original: " + list);
		 
		Collections.reverse(list);
		
		System.out.println("Reverse: " + list);
		
		var des = new ArrayList<Integer>();
		Collections.addAll(des, null, null, null, null, null, null, null, null, null, null);
		Collections.copy(des, list);
		System.out.println("Copy: " + des);
		
		System.out.println(Collections.disjoint(Arrays.asList(100, 200, 10), list));
		
	}

}
