package com.jdc.location.api;

import java.util.List;
import java.util.Optional;

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

import com.jdc.location.model.dto.DivisionDTO;
import com.jdc.location.model.dto.form.DivisionForm;
import com.jdc.location.model.service.DivisionService;
import com.jdc.location.model.service.ParserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("division")
@RequiredArgsConstructor
public class DivisionApi {
	
	private final DivisionService service;
	private final ParserService parser;
	
	@GetMapping("region")
	public List<String> getAllRegions() {
		return service.findAllRegions();
	}

	@GetMapping
	public List<DivisionDTO> search(
			@RequestParam Optional<String> region, 
			@RequestParam Optional<String> keyword) {
		return service.search(region, keyword);
	}
	
	@PostMapping
	public DivisionDTO create(
			@Validated @RequestBody DivisionForm form,
			BindingResult result) {
		
		return service.create(form);
	}
	
	@GetMapping("{id}")
	public DivisionDTO findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@PutMapping("{id}")
	public DivisionDTO update(@PathVariable int id, 
			 @Validated @RequestBody DivisionForm form,
			 BindingResult result) {

		return service.update(id, form);
	}
	
	@PostMapping("upload")
	public long upload(@RequestParam MultipartFile file) {
		return service.upload(parser.parse(file));
	}
	
	@DeleteMapping("{id}")
	public Integer delete(@PathVariable int id) {
		return service.delete(id);
	}
}
