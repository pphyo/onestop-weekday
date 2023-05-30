package com.jdc.proto;

public final class Rectangle extends Shape {

	public Rectangle(int width, int height) {
		super(width, height);
	}

	@Override
	public Shape clone(int width, int height) {
		return new Rectangle(width, height);
	}

	@Override
	public int calculateArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
