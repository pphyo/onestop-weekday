package com.jdc.balance.model.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.BalanceDto;
import com.jdc.balance.model.dto.BalanceListDto;
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
		return BalanceDto.from(balanceRepo.save(transferBalance(0, form)));
	}

	private Balance transferBalance(int id, BalanceForm form) {
		Balance b = null;
		
		if(id == 0)
			b = new Balance();
		else
			b = balanceRepo.findById(id).orElseThrow();

		b.setType(form.type());
		b.setAmount(form.amount());
		b.setNote(form.note());

		// get accountFrom
		var from = getAccount(form.accountFrom());

		b.setAccountFrom(from);

		// get category
		var category = categoryRepo.findByName(form.category()).orElse(null);

		if (form.type() == BalanceType.Income) {

			from.setInitialAmount(from.getInitialAmount() + form.amount());
			b.setCategory(category);

		} else {
			// minus amount from accountFrom
			from.setInitialAmount(from.getInitialAmount() - form.amount());

			b.setAccountFrom(from);

			if (form.type() == BalanceType.Transfer) {
				// get accountTo
				var to = getAccount(form.accountTo());

				// plus amount to accountTo
				to.setInitialAmount(to.getInitialAmount() + form.amount());

				b.setAccountTo(to);
			} else {
				b.setCategory(category);
			}
		}
		return b;
	}

	private Account getAccount(String name) {
		return accountRepo.findByName(name).orElseThrow(() -> {
			throw new BalanceApiException("Finding account error with %s".formatted(name));
		});
	}

	public BalanceDto update(int id, BalanceForm form) {
		revertAmount(id);
		return BalanceDto.from(transferBalance(id, form));
	}
	
	@Transactional(readOnly = true)
	public Optional<Double> findTotalExpense(BalanceType type) {
		return balanceRepo.findTotalExpense(type);
	}

	@Transactional(readOnly = true)
	public Map<LocalDate, List<BalanceListDto>> getBalanceInDayInMonth(LocalDate date) {
		
		var result = new HashMap<LocalDate, List<BalanceListDto>>();

		var dtoList = balanceRepo.getBalanceInMonth().stream().sorted().toList();

		// get distinct date from balance
		var ldList = balanceRepo.findDaysInMonth().stream().map(ldt -> ldt.toLocalDate()).distinct().sorted((a, b) -> b.compareTo(a)).toList();

		for (var ld : ldList) {

			var list = new ArrayList<BalanceListDto>();

			if(ld.getYear() == date.getYear() && ld.getMonthValue() == date.getMonthValue()) {
				
				for (var dto : dtoList) {				

					if (dto.creation().toLocalDate().isEqual(ld)) {
						list.add(dto);
						result.put(ld, list);
					}

				}
			}
			

		}

		return result;
	}

	public void delete(int id) {
		revertAmount(id);
		balanceRepo.deleteById(id);		
	}

	private void revertAmount(int id) {

		var bal = balanceRepo.findById(id).orElseThrow(() -> {throw new BalanceApiException("No record found with %d".formatted(id));});
		var from = bal.getAccountFrom();
		
		if(bal.getType() == BalanceType.Income) {
			from.setInitialAmount(from.getInitialAmount() - bal.getAmount());
		} else {
						
			from.setInitialAmount(from.getInitialAmount() + bal.getAmount());
			
			if(bal.getType() == BalanceType.Transfer) {
				var to = bal.getAccountTo();
				to.setInitialAmount(to.getInitialAmount() - bal.getAmount());
			}

		}
	}

}
