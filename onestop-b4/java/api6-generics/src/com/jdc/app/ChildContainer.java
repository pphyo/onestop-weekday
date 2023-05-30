package com.jdc.app;

public class ChildContainer<T> extends Container<T> {
	
	@Override
	public ChildContainer<Animal> getObj() {
		return null;
	}

}
