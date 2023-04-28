package com.jdc.app;

public class Container<T> {

	private T data;

	public Container() {
	}

	public Container(T data) {
		super();
		this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
	
	public Container<Animal> getObj() {
		return null;
	}

}





