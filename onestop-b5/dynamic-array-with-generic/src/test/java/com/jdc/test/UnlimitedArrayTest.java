package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.dynamic.UnlimitedArray;

// deleteLast homework

public class UnlimitedArrayTest {
	
	@Test
	void test_for_delete_first_element() {

		var arr = new UnlimitedArray<Integer>();
		assertThrows(IllegalArgumentException.class, () -> arr.deleteLast());
		
		arr.insert(100);
		arr.insert(200);
		arr.insert(300);
				
		assertEquals(3, arr.size());
		assertArrayEquals(new Integer[] {100, 200, 300}, arr.getArray());
		
		var deletedElement = arr.deleteFirst();
		assertEquals(100, deletedElement);
		assertEquals(2, arr.size());
		assertArrayEquals(new Integer[] {200, 300}, arr.getArray());
	}
	
	@Test
	@Disabled
	void test_for_delete_last_element() {
		
		var arr = new UnlimitedArray<Integer>();
		assertThrows(IllegalArgumentException.class, () -> arr.deleteLast());
		
		arr.insert(100);
		arr.insert(200);
		arr.insert(300);
				
		assertEquals(3, arr.size());
		assertArrayEquals(new Integer[] {100, 200, 300}, arr.getArray());
		
		var deletedElement = arr.deleteLast();
		assertEquals(300, deletedElement);
		assertEquals(2, arr.size());
		assertArrayEquals(new Integer[] {100, 200}, arr.getArray());
	}
	
	@Test
	@Disabled
	void test_for_insert() {
		
		var intArr = new UnlimitedArray<>();
		boolean result = intArr.insert(10);
		assertTrue(result);
		assertEquals(1, intArr.size());
		
		var strArr = new UnlimitedArray<>();
		assertFalse(strArr.insert(null));
		assertEquals(0, strArr.size());
		
	}

}
