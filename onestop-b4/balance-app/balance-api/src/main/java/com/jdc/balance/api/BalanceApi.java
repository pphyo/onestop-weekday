package com.jdc.balance.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.BalanceDto;
import com.jdc.balance.model.dto.BalanceListDto;
import com.jdc.balance.model.dto.form.BalanceForm;
import com.jdc.balance.model.entity.Balance.BalanceType;
import com.jdc.balance.model.service.BalanceService;

@RestController
@RequestMapping("balances")
public class BalanceApi {
	
	@Autowired
	private BalanceService service;
	
	@PostMapping
	public BalanceDto save(@Validated @RequestBody BalanceForm form, BindingResult result) {
		
		if(result.hasErrors())
			throw new BalanceApiException(result.getFieldErrors());
		
		return service.save(form);
	}
	
	@GetMapping("{date}")
	public Map<LocalDate, List<BalanceListDto>> searchInSpecificMonth(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return service.getBalanceInDayInMonth(date);
	}
	
	@GetMapping("type/{type}")
	public double findExpenseAmount(@PathVariable BalanceType type) {
		return service.findTotalExpense(type).orElse(0.0);
	}

}
