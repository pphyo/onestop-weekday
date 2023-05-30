package com.jdc.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IterateApp {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "Duck", "Bucket", "Elephant", "Book", "Borrow", "Apple");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
//			String el = itr.next();
			if(itr.next().startsWith("Bo"))
				itr.remove();
		}
		
//		for(String str : list) {    // ConcurrentModificationException
//			if(str.startsWith("Bo"));
//				list.remove(str);
//		}
		
		System.out.println(list);

	}

}
