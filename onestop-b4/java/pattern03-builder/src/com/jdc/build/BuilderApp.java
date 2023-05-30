package com.jdc.build;

public class BuilderApp {

	public static void main(String[] args) {
		
		ItemBuilder builder = new ItemBuilder();
		
		Item item = builder.createItem()
						   .addQuantity(10)
						   .addName("Royal Sloute")
						   .addStock(true)
						   .addPrice(40000.546)
						   .addQuantity(2)
						   .addGrade('A')
						   .build();
		
		String result = """
				%-8s: %s
				%-8s: %.2f
				%-8s: %d
				%-8s: %s
				%-8s: %s
				""".formatted("Name", item.getName(),
						"Price", item.getPrice(),
						"Quantity", item.getQuantity(),
						"Stock", item.isStock(),
						"Grade", item.getGrade()
						);
		
		System.out.println(result);
		
	}

}
