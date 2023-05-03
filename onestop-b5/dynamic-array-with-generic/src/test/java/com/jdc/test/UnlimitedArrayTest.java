package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.jdc.dynamic.UnlimitedArray;

// deleteLast homework

public class UnlimitedArrayTest {
	
	@Test
	void test() {
		
		var intArr = new UnlimitedArray<>();
		boolean result = intArr.insert(10);
		assertTrue(result);
		assertEquals(1, intArr.size());
		
		var strArr = new UnlimitedArray<>();
		assertFalse(strArr.insert(null));
		assertEquals(0, strArr.size());
		
	}

}
