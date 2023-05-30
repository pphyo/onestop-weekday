package com.jdc.proto;

public final class Square extends Shape {

	public Square(int width) {
		super(width, width);
	}

	@Override
	public Shape clone(int width, int height) {
		return new Square(width);
	}

	@Override
	public int calculateArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
