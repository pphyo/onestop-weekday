package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jdc.generic.BeforeGenricBox;
import com.jdc.generic.GenericBox;

public class GenericTest {
	
	@Test
	void test_for_non_generic() {
		// raw type => Object type
		BeforeGenricBox boxOne = new BeforeGenricBox("Box One");
		boxOne.setData(100);
		boxOne.setData(2000.000);
		assertEquals(2000d, boxOne.getData());
	}
	
	@Test
	void test_for_generic() {
		GenericBox<String> strBox = new GenericBox<String>("A");
		strBox.setData("String Box");
		assertEquals("String Box", strBox.getData());
		
		GenericBox<Double> douBox = new GenericBox<>(200d);
		douBox.setData(49D);
	}

}
