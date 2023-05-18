package com.jdc.generic;

public class SubPair<A, B> implements Pair<A, B> {

	private A key;
	private B value;

	public SubPair(A key, B value) {
		super();
		this.key = key;
		this.value = value;
	}

	public A getKey() {
		return key;
	}

	public B getValue() {
		return value;
	}

}
