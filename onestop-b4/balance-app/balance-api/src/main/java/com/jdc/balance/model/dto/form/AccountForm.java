package com.jdc.balance.model.dto.form;

import com.jdc.balance.model.entity.Account;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AccountForm(
		@NotBlank(message = "Account name can't be empty!")
		String name,
		@Min(value = 100, message = "Enter correct amount!")
		double initialAmount,
		String icon
		) {
	
	public Account entity() {
		var acc = new Account();
		acc.setName(name);
		acc.setInitialAmount(initialAmount);
		acc.setIcon(icon);
		return acc;
	}

}
