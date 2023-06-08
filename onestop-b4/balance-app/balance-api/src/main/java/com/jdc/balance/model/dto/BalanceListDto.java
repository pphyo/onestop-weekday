package com.jdc.balance.model.dto;

import java.time.LocalDateTime;

import com.jdc.balance.model.entity.Balance.BalanceType;

public record BalanceListDto(
		LocalDateTime creation,
		BalanceType type,
		double amount,
		String categoryName,
		String categoryIcon,
		String accountFromName,
		String accountFromIcon,
		String accountToName,
		String accountToIcon,
		String note
		) implements Comparable<BalanceListDto> {

	@Override
	public int compareTo(BalanceListDto o) {
		return o.creation().compareTo(this.creation());
	}

}
