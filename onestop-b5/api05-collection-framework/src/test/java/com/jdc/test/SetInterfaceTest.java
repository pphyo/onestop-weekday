package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class SetInterfaceTest {
	
	@Test
	void test_for_hashset_class() {
		var hs = new TreeSet<Integer>();
		Collections.addAll(hs, 2, 4, 6, 8, 9, 7, 5, 3, 1);
		assertEquals(1, hs.first());
		System.out.println(hs.last());
	}

}
