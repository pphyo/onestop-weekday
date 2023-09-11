package com.jdc.location.model.dto;

import com.jdc.location.model.entity.Account;

public record AccountDTO(
		int id,
		String loginId,
		String password
		) {
	
	public static AccountDTO from(Account acc) {
		return new AccountDTO(acc.getId(), acc.getLoginId(), acc.getPassword());
	}

}
