package com.jdc.location.api;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.location.model.dto.TownshipDTO;
import com.jdc.location.model.dto.form.TownshipForm;
import com.jdc.location.model.service.TownshipService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("township")
@RequiredArgsConstructor
public class TownshipApi {
	
	private final TownshipService service;

	@GetMapping
	List<TownshipDTO> search(
			@RequestParam Optional<String> region, 
			@RequestParam Optional<Integer> division, 
			@RequestParam Optional<String> keyword) {
		return service.search(region, division, keyword);
	}
	

	@GetMapping("{id}")
	TownshipDTO findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	TownshipDTO create(@Validated @RequestBody TownshipForm form, BindingResult result) {
		return service.create(form);
	}
	
	@PutMapping("id")
	TownshipDTO update(@PathVariable int id, 
			@Validated @RequestBody TownshipForm form, 
			BindingResult result) {
		return service.update(id, form);
	}
}
