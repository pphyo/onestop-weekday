package com.jdc.app;

@SuppressWarnings("all")
public class NaturalInteger<T extends Integer> {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public boolean isEven() {
		return data % 2 == 0;
	}

}
