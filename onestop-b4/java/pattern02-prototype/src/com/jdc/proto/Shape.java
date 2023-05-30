package com.jdc.proto;

public sealed abstract class Shape permits Rectangle, Square {

	private int width;
	private int height;

	public Shape(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public abstract Shape clone(int width, int height);
	public abstract int calculateArea();

}
