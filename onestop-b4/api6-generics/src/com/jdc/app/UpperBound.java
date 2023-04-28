package com.jdc.app;

public class UpperBound<T> {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public <U extends Number> void inspect(U u) { // extends or upper bound
		System.out.println("T: " + data.getClass().getName());
		System.out.println("U: " + u.getClass().getName());
	}

	public static void main(String[] args) {
		UpperBound<Integer> bound = new UpperBound<>();
		bound.setData(100);
//		bound.inspect("");
	}

}





