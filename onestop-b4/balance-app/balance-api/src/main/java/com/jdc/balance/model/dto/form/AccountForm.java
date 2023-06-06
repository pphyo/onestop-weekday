package com.jdc.balance.model.dto.form;

import com.jdc.balance.model.entity.Account;

public record AccountForm(
		String name,
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
