package com.jdc.build;

public class Item {

	private String name;
	private double price;
	private int quantity;
	private boolean stock;
	private char grade;

	public Item() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

//	public Item(String name, double price, int quantity, boolean stock, char grade) {
//		super();
//		this.name = name;
//		this.price = price;
//		this.quantity = quantity;
//		this.stock = stock;
//		this.grade = grade;
//	}

}
