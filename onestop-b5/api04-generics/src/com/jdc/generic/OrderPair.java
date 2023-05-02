package com.jdc.generic;

public class OrderPair<K> implements Pair<K, Integer> {

	private K key;
	private Integer value;

	public OrderPair(K key, Integer value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public Integer getValue() {
		return value;
	}

}
