package com.jdc.balance.model.dto.form;

import com.jdc.balance.model.entity.Category;
import com.jdc.balance.model.entity.Category.CategoryType;

import jakarta.validation.constraints.NotBlank;

public record CategoryForm(
		@NotBlank(message = "Name cannot be empty!")
		String name,
		@NotBlank(message = "Please select category type!")
		String type,
		String icon
		) {

	public Category entity() {
		var c = new Category();
		c.setName(name);
		c.setType(CategoryType.valueOf(type));
		c.setIcon(icon);
		return c;
	}
	
}










