package com.jdc.app;

public record Item(
		int id,
		String name,
		double price,
		String category,
		boolean stock
		) {

}
