package com.jdc.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionApp {

	public static void main(String[] args) {
		
		listInterface();

	}
	
	static void listInterface() {
		
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		
		for(int i = 1; i < 100; i += 11) {
			arrayList.add(i);
			linkedList.add(i);
		}
		
		System.out.println(arrayList);
		System.out.println(linkedList);
		System.out.println("Size: " + arrayList.size());
		
		arrayList.add(5, 89);
		System.out.println(arrayList);
		
		linkedList.addAll(1, arrayList);
		System.out.println(linkedList);
		
		System.out.println("indexOf: " + arrayList.indexOf(89));
		System.out.println("get: " + arrayList.get(9));
		System.out.println("lastIndexOf: " + arrayList.lastIndexOf(89));
		System.out.println("" + arrayList.remove(Integer.valueOf(89)));
		System.out.println("" + arrayList.set(4, 10_000));
		
		System.out.println(arrayList);
		
	}
	
	static void setInterface() {
		
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(10);
		hashSet.add(54);
		hashSet.add(3);
		hashSet.add(39);
		hashSet.add(28);
		hashSet.add(100);
		
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.addAll(hashSet);
		
		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		Collections.addAll(linkedHashSet, 5, 10, 11, 53, 42, 9);
		
		System.out.println(hashSet);
		System.out.println(treeSet);
		System.out.println(linkedHashSet);
		
		System.out.println("Size: " + hashSet.size());
		System.out.println("Contain: " + hashSet.contains(100));
		System.out.println("isEmpty: " + hashSet.isEmpty());
		System.out.println("containsAll: " + hashSet.containsAll(linkedHashSet));
	
		hashSet.remove(Integer.valueOf(2000));
		treeSet.add(5000);
		
		System.out.println("retainAll: " + hashSet.retainAll(treeSet));
		
		System.out.println("TreeSet: " + treeSet);
		
		System.out.println("HashSet: " + hashSet);
		
		System.out.println("containsAll: " + hashSet.containsAll(treeSet));
		
		System.out.println("removeAll: " + hashSet.removeAll(treeSet));
		
		System.out.println("HashSet: " + hashSet);

		hashSet.clear();
		
		System.out.println("isEmpty: " + hashSet.isEmpty());
		
	}

}








