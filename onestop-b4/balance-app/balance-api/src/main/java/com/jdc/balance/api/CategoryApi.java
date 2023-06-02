package com.jdc.balance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.CategoryDto;
import com.jdc.balance.model.dto.form.CategoryForm;
import com.jdc.balance.model.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryApi {
	
	@Autowired
	private CategoryService service;
	
	@PostMapping
	CategoryDto create(
			@Validated
			@RequestBody
			CategoryForm form,
			BindingResult result) {
		if(result.hasErrors()) {
			throw new BalanceApiException(result.getFieldErrors());
		}
		return service.save(form);
	}
	
	@PutMapping("{id}")
	CategoryDto update(@PathVariable int id,
			@Validated
			@RequestBody
			CategoryForm form, BindingResult result) {
		
		if(result.hasErrors())
			throw new BalanceApiException(result.getFieldErrors()); 
		
		return service.update(id, form);
	}

}




