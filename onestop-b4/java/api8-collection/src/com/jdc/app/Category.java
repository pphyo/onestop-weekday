package com.jdc.app;

import java.time.LocalDate;

public class Category implements Comparable<Category> {

	private int id;
	private static int count = 1;
	private String name;
	@SuppressWarnings("unused")
	private LocalDate createdAt;
	private String creator;

	public Category(String name, String creator) {
		id = count;
		this.name = name;
		this.creator = creator;
		count++;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getCreatedAt() {
		return LocalDate.now();
	}

	public String getCreator() {
		return creator;
	}
	
	public String toString() {
		return """
				id: %d, Name: %s, CreateDate: %s, Creator: %s
				""".formatted(id, name, getCreatedAt(), creator);
	}
	
	@Override
	public int compareTo(Category o) {
		return name.compareTo(o.getName());
	}

}







