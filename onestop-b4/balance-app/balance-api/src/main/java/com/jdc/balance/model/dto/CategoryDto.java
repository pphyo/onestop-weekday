package com.jdc.balance.model.dto;

import com.jdc.balance.model.entity.Category;
import com.jdc.balance.model.entity.Category.CategoryType;

public record CategoryDto(
		int id,
		String name,
		CategoryType type,
		String icon
		) {
	
	public static CategoryDto from(Category c) {
		return new CategoryDto(c.getId(), 
				c.getName(), c.getType(), c.getIcon());
	}

}






