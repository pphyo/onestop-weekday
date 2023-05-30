package com.jdc.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortApp {

	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(5, 1, 3, 6, 8, 3, 2);
		
		intList.set(2, 7);
		Collections.sort(intList);
		
		System.out.println(intList);
		
		List<String> strList = Arrays.asList("Messi", "Kelvin", "Albert", "Kiboy", "CW");
		Collections.shuffle(strList);
		
		System.out.println(strList);
		
		Category c1 = new Category("Foods", "Zaw Min Aung");
		Category c2 = new Category("Drinks", "Kyaw Kyaw");
		Category c3 = new Category("Fashion", "Min Khant");
		Category c4 = new Category("Electronic", "Thurein");
		Category c5 = new Category("Snacks", "Nandar");
		
		List<Category> catList = Arrays.asList(c1, c2, c3, c4, c5);
		
		Comparator<Category> com = new Comparator<Category>() {
			@Override
			public int compare(Category o1, Category o2) {
				return o1.getId() - o2.getId();
			}
		};
		
		Collections.sort(catList, Collections.reverseOrder(com));
		
		System.out.println(catList);
		
		
//		List<String> strList = List.of("Messi", "Kelvin", "Albert", "Kiboy", "CW");
		
//		Collections.sort(strList);
//
//		List<Integer> otherList = Collections.unmodifiableList(intList);
//		otherList.add(49);
		
	}

}
