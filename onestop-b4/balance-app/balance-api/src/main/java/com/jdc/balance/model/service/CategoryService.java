package com.jdc.balance.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.CategoryDto;
import com.jdc.balance.model.dto.form.CategoryForm;
import com.jdc.balance.model.entity.Category.CategoryType;
import com.jdc.balance.model.repo.CategoryRepository;

import jakarta.validation.Valid;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public CategoryDto save(@Valid CategoryForm form) {
		return CategoryDto.from(repo.save(form.entity()));
	}

	public CategoryDto update(int id, @Valid CategoryForm form) {
		return repo.findById(id)
				   .map(c -> {
					   c.setName(form.name());
					   c.setType(CategoryType.valueOf(form.type()));
					   c.setIcon(form.icon());
					   return CategoryDto.from(c);
				   }).orElseThrow(() -> {
					   throw new BalanceApiException("Category update error with %d".formatted(id));
					  });
	}
	
}






