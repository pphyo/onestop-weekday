package com.jdc.generic;

public class Box<T> {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public <U extends Number> void inspect(U u) {
		System.out.println("T: " + data.getClass().getName());
		System.out.println("U: " + u.getClass().getName());
	}

}
