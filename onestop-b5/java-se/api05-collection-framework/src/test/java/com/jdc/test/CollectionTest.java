package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CollectionTest {
	
	@Test
	void test_for_map() {
		
		var hm = new HashMap<String, String>();
		hm.put("Thai", "Bangkok");
		hm.put("Indonesia", "Jakarta");
		hm.put("Phillipine", "Manila");
		hm.put("Myanmar", "Yangon");
		hm.put("China", "Beijin");
		hm.put("Korea", "Souel");
		hm.put("Japan", "Kyoto");
		hm.put("Japan", "Tokyo");
		hm.put("Cambodia", "Tokyo");
		
		hm.remove("China");
		hm.remove("Korea", "Souel");
		hm.replace("Myanmar", "Naypyidaw");
		
		assertTrue(hm.containsKey("Myanmar"));
		assertFalse(hm.containsKey("Laos"));
		assertTrue(hm.containsValue("Tokyo"));
		assertFalse(hm.containsValue("Hong Kong"));
		assertEquals("Naypyidaw", hm.get("Myanmar"));
		
		Set<Entry<String, String>> entrySet = hm.entrySet();
		
		for(Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		System.out.println(hm.keySet());
		
		System.out.println(hm.values());
		
		System.out.println(hm);
		
	}
	
	@Test
	@Disabled
	void test_for_queue() throws InterruptedException {
		
		PriorityQueue<Integer> priQue = new PriorityQueue<>();
		LinkedList<Integer> que = new LinkedList<>();
		
		for(int i = 0; i < 10; i++) {
			que.offer(i + 1);
			priQue.offer(i + 1);
		}
		
		assertEquals(10, que.size());
		assertEquals(1, que.element());
		
		while(!que.isEmpty()) {
			System.out.println(que.poll());
			Thread.sleep(500);
		}
		
		assertTrue(que.isEmpty());
		
	}
	
	@Test
	@Disabled
	void test_for_list() {
		
		List<String> list = new ArrayList<>();
		list.add("Abe");
		list.add("Ragner");
		list.add("Connie");
		list.add("Brown");
		list.add(0, "Dubi");
		list.add(2, "Abe");
		
		assertEquals(6, list.size());
		assertFalse(list.isEmpty());
		
		List<Integer> linkedList = new LinkedList<>();
		Collections.addAll(linkedList, 100, 200, 300, 400, 500, 300);
		assertEquals(6, linkedList.size());
		assertAll(
				() -> assertEquals(100, linkedList.get(0)),
				() -> assertEquals(200, linkedList.get(1)),
				() -> assertEquals(300, linkedList.get(2)),
				() -> assertEquals(400, linkedList.get(3)),
				() -> assertEquals(500, linkedList.get(4)),
				() -> assertEquals(300, linkedList.get(5))
			);
		
		assertEquals(2, linkedList.indexOf(300));
		assertEquals(5, linkedList.lastIndexOf(300));
		
//		assertEquals(300 ,linkedList.remove(5));
//		assertEquals(5, linkedList.size());
		
		assertTrue(linkedList.remove(Integer.valueOf(300)));
		System.out.println(linkedList);
		
		assertEquals(500, linkedList.set(3, 1000));
		System.out.println(linkedList);
		
		
	}
	
	@Test
	@Disabled
	void test_for_set() {
		
		Set<Integer> hashSet = new HashSet<>();
		
		assertTrue(hashSet.isEmpty());
		
		hashSet.add(7);
		hashSet.add(1);
		hashSet.add(8);
		hashSet.add(4);
		hashSet.add(10);
		hashSet.add(6);
		hashSet.add(2);
		hashSet.add(10);
		
		assertEquals(7, hashSet.size());
		assertFalse(hashSet.isEmpty());
		assertTrue(hashSet.contains(10));
		assertFalse(hashSet.contains(100));
		
		Set<Integer> otherSet = Set.of(7, 1, 8, 4, 10, 6, 2);
		
		assertTrue(hashSet.containsAll(otherSet));
		
		System.out.println(hashSet.retainAll(otherSet));
		
		System.out.println(otherSet);
		
		System.out.println(hashSet);
		
//		assertTrue(hashSet.remove(10));
//		assertEquals(6, hashSet.size());
//		
//		assertFalse(hashSet.remove(10000));
//		
//		hashSet.clear();
//		
//		assertTrue(hashSet.isEmpty());
//		assertEquals(0, hashSet.size());
		
		Set<Integer> treeSet = new TreeSet<>(hashSet);
		System.out.println(treeSet);
		
		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(7);
		linkedHashSet.add(1);
		linkedHashSet.add(8);
		linkedHashSet.add(4);
		linkedHashSet.add(10);
		linkedHashSet.add(6);
		linkedHashSet.add(2);
		linkedHashSet.add(10);
		System.out.println(linkedHashSet);
		
	}

}
