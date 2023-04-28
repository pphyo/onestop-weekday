package com.jdc.app;

public class Util {
	
	public static <K, V> boolean compareKey(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey() == p2.getKey();
	}
	
}
