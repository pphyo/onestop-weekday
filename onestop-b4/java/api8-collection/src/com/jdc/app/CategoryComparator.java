package com.jdc.app;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Category> {

	@Override
	public int compare(Category o1, Category o2) {
		return o1.getCreator().compareTo(o2.getCreator());
	}

}
