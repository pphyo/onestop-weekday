package com.jdc.generic;

public class GenericBox<T> {

	private T data;

	public GenericBox(T data) {
		super();
		this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
	
}
