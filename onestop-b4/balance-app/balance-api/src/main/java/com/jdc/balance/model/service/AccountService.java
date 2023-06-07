package com.jdc.balance.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.AccountDto;
import com.jdc.balance.model.dto.form.AccountForm;
import com.jdc.balance.model.repo.AccountRepository;

import jakarta.validation.Valid;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountRepository repo;
	
	public AccountDto save(@Valid AccountForm form) {
		return AccountDto.from(repo.save(form.entity()));
	}

	@Transactional(readOnly = true)
	public List<AccountDto> search() {
		return repo.findAll().stream().map(a -> AccountDto.from(a)).toList();
	}
	
	@Transactional(readOnly = true)
	public Optional<Long> getTotalAmount() {
		return repo.getTotalAmount();
	}
	
	public AccountDto update(int id, @Valid AccountForm form) {
		return repo.findById(id)
				   .map(acc -> {
					   acc.setName(form.name());
					   acc.setInitialAmount(form.initialAmount());
					   acc.setIcon(form.icon());
					   return AccountDto.from(acc);
				   }).orElseThrow(() -> {throw new BalanceApiException("Account update error with %d.".formatted(id));});
	}

	public void remove(int id) {
		repo.deleteById(id);		
	}

}
