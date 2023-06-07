package com.jdc.balance.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.CategoryDto;
import com.jdc.balance.model.dto.form.CategoryForm;
import com.jdc.balance.model.entity.Category;
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

	@Transactional(readOnly = true)
	public List<CategoryDto> search(Optional<String> name, Optional<CategoryType> type) {
		return repo.findAll(
				   categorySpec(name.filter(StringUtils::hasLength))
				   .and(typeSpec(type.filter(t -> null != t))))
				   .stream().map(CategoryDto::from).toList();
	}

	private Specification<Category> typeSpec(Optional<CategoryType> type) {
		return type.isEmpty() ? Specification.where(null) :
			(root, query, cb) -> cb.equal(root.get("type"), type.get());
	}

	private Specification<Category> categorySpec(Optional<String> name) {
		return name.isEmpty() ? Specification.where(null) :
				(root, query, cb) -> cb.like(root.get("name"), name.get().concat("%"));
	}

	@Transactional(readOnly = true)
	public CategoryDto findById(int id) {
		return repo.findById(id)
				.map(CategoryDto::from)
				.orElseThrow(() -> {
					throw new BalanceApiException("No category found with ID %d.".formatted(id));
				});
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}

	public List<CategoryDto> upload(List<String> lines) {
		
		for(String line : lines) {
			var arr = line.split("\t");
			
			if(arr.length == 3)
				save(new CategoryForm(arr[0], arr[1], arr[2]));
			else if(arr.length == 2)
				save(new CategoryForm(arr[0], arr[1], null));
			else
				throw new BalanceApiException("Invalid File Layout!");
						
		}
			
		
		return search(Optional.empty(), Optional.empty());
	}

	public List<CategoryDto> findByType(CategoryType type) {
		return repo.findByType(type).stream().map(CategoryDto::from).toList();
	}
}






