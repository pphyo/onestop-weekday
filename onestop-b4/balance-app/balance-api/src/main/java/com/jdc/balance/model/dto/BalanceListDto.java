package com.jdc.balance.model.dto;

import java.time.LocalDateTime;

import com.jdc.balance.model.entity.Balance.BalanceType;

public record BalanceListDto(
		int id,
		LocalDateTime creation,
		BalanceType type,
		double amount,
		String category,
		String categoryIcon,
		String accountFrom,
		String accountFromIcon,
		String accountTo,
		String accountToIcon,
		String note
		) implements Comparable<BalanceListDto> {

	@Override
	public int compareTo(BalanceListDto o) {
		return o.creation().compareTo(this.creation());
	}

}
