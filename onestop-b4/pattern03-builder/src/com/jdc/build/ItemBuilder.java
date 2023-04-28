package com.jdc.build;

public class ItemBuilder {
	
	private Item item;
	
	public ItemBuilder createItem() {
		item = new Item();
		return this;
	}
	
	public ItemBuilder addName(String name) {
		item.setName(name);
		return this;
	}
	
	public ItemBuilder addPrice(double price) {
		item.setPrice(price);
		return this;
	}
	
	public ItemBuilder addQuantity(int quantity) {
		item.setQuantity(quantity);
		return this;
	}
	
	public ItemBuilder addStock(boolean stock) {
		item.setStock(stock);
		return this;
	}
	
	public ItemBuilder addGrade(char grade) {
		item.setGrade(grade);
		return this;
	}
	
	public Item build() {
		return item;
	}

}
