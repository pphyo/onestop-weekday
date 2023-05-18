package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.jdc.generic.BeforeGenricBox;
import com.jdc.generic.GenericBox;
import com.jdc.generic.OrderPair;
import com.jdc.generic.Pair;
import com.jdc.generic.SubPair;

public class GenericTest {
	
	public GenericTest() {System.out.println("Test Constructor");}
//	public <K, V> GenericTest(Pair<K, V> p1, Pair<K, V> p2) {}
	
	<K, V> boolean compair(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
	
	@Test
	void test_for_multiple_type() {
		Pair<String, Integer> p1 = new OrderPair<>("Apple", 2000);
		Pair<Integer, Integer> p2 = new OrderPair<>(100, 100);
		
		Pair<String, Integer> p5 = new OrderPair<>("Orange", 2000);
		
		assertFalse(compair(p1, p5));
		
		Pair<Double, Double> p3 = new Pair<Double, Double>() {

			@Override
			public Double getKey() {
				return 100D;
			}

			@Override
			public Double getValue() {
				return 200D;
			}
			
		};
		
		Pair<Character, Boolean> p4 = new SubPair<>('\u1000', true);
		
		assertAll(
				() -> assertEquals("Apple", p1.getKey()),
				() -> assertEquals(2000, p1.getValue()),
				() -> assertEquals(100, p2.getKey()),
				() -> assertEquals(100, p2.getValue()),
				() -> assertEquals(100D, p3.getKey()),
				() -> assertEquals(200D, p3.getValue()),
				() -> assertEquals('က', p4.getKey()),
				() -> assertEquals(true, p4.getValue())
			);
		
	}
	
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
