package com.jdc.balance.model.dto.form;

import java.time.LocalDateTime;

import com.jdc.balance.model.entity.Balance.BalanceType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record BalanceForm(
			BalanceType type,
			@NotNull(message = "Please select account!")
			int accountFrom,
			int category,
			int accountTo,
			@Min(value = 1, message = "Enter correct ammount!")
			double amount,
			String note,
			LocalDateTime createdAt
		) {
	

}
