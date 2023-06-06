package com.jdc.balance.api;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.AccountDto;
import com.jdc.balance.model.dto.form.AccountForm;
import com.jdc.balance.model.service.AccountService;

@RestController
@RequestMapping("accounts")
public class AccountApi {
	
	@Autowired
	private AccountService service;
	
	@PostMapping
	public AccountDto create(@RequestBody @Validated AccountForm form, BindingResult result) {
		
		if(result.hasErrors())
			throw new BalanceApiException(result.getFieldErrors());
		
		return service.save(form);
	}
	
	@PutMapping("{id}")
	public AccountDto update(
			@PathVariable
			int id,
			@RequestBody
			@Validated
			AccountForm form, BindingResult result) {
		
		if(result.hasErrors())
			throw new BalanceApiException(result.getFieldErrors());
		
		return service.update(id, form);
		
	}
	
	@GetMapping
	public List<AccountDto> search() {
		return service.search();
	}
	
	@GetMapping("total")
	public Long totalAmountOfAll() {
		return service.getTotalAmount().orElse(null);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		service.remove(id);
	}

}
