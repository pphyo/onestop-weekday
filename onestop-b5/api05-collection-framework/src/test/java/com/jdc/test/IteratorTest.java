package com.jdc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class IteratorTest {
	
	@Test
	void test_for_immutable_type() {
		
		// fix-sized list
		// Not allow for add and remove
		// but allow for set
		var asList = Arrays.asList("Zhask", "Hayabusa", "Kagura", "Hanzo");
		
		System.out.println(asList);
		
		asList.set(1, "Hanabi");
		
		System.out.println(asList);
		
		var ofList = Collections.unmodifiableList(asList);
		
		ofList.set(1, "Connie");
		
	}

	@Test
	@Disabled
	void test_for_iterator() {
		
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "Andy", "Babra", "Cowel", "David", "Babra Liskov", "Campell");
		
		// Not allow remove method in loop
//		for(String item : list) {
//			if(item.startsWith("C"))
//				list.remove(item);
//		}
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			String ele = itr.next();
			if(ele.startsWith("C"))
				itr.remove();
		}
		
		System.out.println(list);
		
	}

}
