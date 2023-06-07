package com.jdc.balance.model.dto;

import com.jdc.balance.model.entity.Account;

public record AccountDto(
		int id,
		String name,
		double initialAmount,
		String icon
		) {
	
	public static AccountDto from(Account acc) {
		return new AccountDto(acc.getId(), acc.getName(), acc.getInitialAmount(), acc.getIcon());
	}

}
