package com.jdc.app;

public class IntContainer<E> extends Container<Integer>{

	private E element;
	
	public IntContainer(E element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return super.getData() + element.toString();
	}
	
}
