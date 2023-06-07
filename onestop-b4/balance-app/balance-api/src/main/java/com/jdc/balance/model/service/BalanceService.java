package com.jdc.balance.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.BalanceDto;
import com.jdc.balance.model.dto.form.BalanceForm;
import com.jdc.balance.model.entity.Account;
import com.jdc.balance.model.entity.Balance;
import com.jdc.balance.model.entity.Balance.BalanceType;
import com.jdc.balance.model.repo.AccountRepository;
import com.jdc.balance.model.repo.BalanceRepository;
import com.jdc.balance.model.repo.CategoryRepository;

import jakarta.validation.Valid;

@Service
@Transactional
public class BalanceService {

	@Autowired
	private BalanceRepository balanceRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public BalanceDto save(@Valid BalanceForm form) {
		

		var b = new Balance();
		
		b.setType(form.type());
		b.setAmount(form.amount());
		b.setNote(form.note());
		
		// get accountFrom
		var from = getAccount(form.accountFrom());

		b.setAccountFrom(from);
		
		// get category
		var category = categoryRepo.findById(form.category()).orElse(null);
		
		if(form.type() == BalanceType.Income) {
			
			from.setInitialAmount(from.getInitialAmount() + form.amount());
			b.setCategory(category);
			
		} else {			
			// minus amount from accountFrom
			from.setInitialAmount(from.getInitialAmount() - form.amount());

			b.setAccountFrom(from);

			if(form.type() == BalanceType.Transfer) {
				// get accountTo
				var to = getAccount(form.accountTo());
				
				// plus amount to accountTo
				to.setInitialAmount(to.getInitialAmount() + form.amount());
				
				b.setAccountTo(to);
			} else {
				b.setCategory(category);
			}
		}
				
		return BalanceDto.from(balanceRepo.save(b));
	}

	private Account getAccount(int id) {
		return accountRepo.findById(id)
				.orElseThrow(() -> {
					throw new BalanceApiException("Finding account error with %d".formatted(id));
				});
	}

	@Transactional(readOnly = true)
	public Optional<Double> findTotalExpense(BalanceType type) {
		return balanceRepo.findTotalExpense(type);
	}
	
}
