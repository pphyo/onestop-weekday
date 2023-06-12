package com.jdc.balance.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.CategoryDto;
import com.jdc.balance.model.dto.form.CategoryForm;
import com.jdc.balance.model.entity.Category.CategoryType;
import com.jdc.balance.model.service.CategoryService;
import com.jdc.balance.model.service.ParserService;

@RestController
@RequestMapping("categories")
public class CategoryApi {

	@Autowired
	private CategoryService service;

	@Autowired
	private ParserService parserService;

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
	
	@GetMapping
	List<CategoryDto> search(
			@RequestParam Optional<String> name,
			@RequestParam Optional<CategoryType> type
			) {
		return service.search(name, type);
	}
	
	@GetMapping("{id}")
	CategoryDto findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("type/{type}")
	List<CategoryDto> findByType(@PathVariable CategoryType type) {
		return service.findByType(type);
	}
	
	@DeleteMapping("{id}")
	void delete(@PathVariable int id) {
		service.delete(id);
	}
	
	@PostMapping("upload")
	List<CategoryDto> upload(@RequestParam MultipartFile file) {
		return service.upload(parserService.parse(file));
	}

}