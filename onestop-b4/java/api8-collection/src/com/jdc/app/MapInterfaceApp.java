package com.jdc.app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapInterfaceApp {

	public static void main(String[] args) {
		
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("Myanmar", "Yangon");
		hashMap.put("Thailand", "Bangkok");
		hashMap.put("Korea", "Souel");
		hashMap.put("Japan", "Tokyo");
		hashMap.put("Phillipine", "Manila");
		hashMap.put("Myanmar", "Naypyidaw");
		
		System.out.println(hashMap);
		
		Map<String, String> treeMap = new TreeMap<>();
		treeMap.putAll(hashMap);
		
		System.out.println(treeMap);
		
		System.out.println("containsKey: " + hashMap.containsKey("Vietnam"));
		System.out.println("containsValue: " + hashMap.containsValue("Manila"));
		System.out.println("get: " + hashMap.get("Myanmar"));
		System.out.println("remove: " + hashMap.remove("Tokyo"));
		
		System.out.println(hashMap);
		
		Set<String> keys = hashMap.keySet();
		System.out.println(keys);
		
		Collection<String> vals = hashMap.values();
		System.out.println(vals);
		
		Set<Entry<String, String>> entrySet = hashMap.entrySet();
		
		for(Entry<String, String> entry : entrySet) {
			if(entry.getKey().equals("Myanmar"))
				entry.setValue("Yangon");
			
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		System.out.println(hashMap);

	}

}









