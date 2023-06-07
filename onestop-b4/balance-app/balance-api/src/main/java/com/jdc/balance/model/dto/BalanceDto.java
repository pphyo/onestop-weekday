package com.jdc.balance.model.dto;

import com.jdc.balance.model.entity.Balance;
import com.jdc.balance.model.entity.Account;
import com.jdc.balance.model.entity.Category;
import com.jdc.balance.model.entity.Balance.BalanceType;
import java.time.LocalDateTime;

public record BalanceDto(
		int id,
		BalanceType type,
		double amount,
		LocalDateTime createdAt,
		String note,
		Account accountFrom,
		Category category,
		Account accountTo
		) {
	
	public static BalanceDto from(Balance b) {
		return new BalanceDto(
					b.getId(), b.getType(), 
					b.getAmount(), b.getCreatedAt(), 
					b.getNote(), b.getAccountFrom(),
					b.getCategory(), b.getAccountTo()
				);
	}

}
