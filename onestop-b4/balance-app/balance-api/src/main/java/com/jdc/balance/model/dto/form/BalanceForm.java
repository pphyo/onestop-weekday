package com.jdc.balance.model.dto.form;

import java.time.LocalDateTime;

import com.jdc.balance.model.entity.Balance.BalanceType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record BalanceForm(
			BalanceType type,
			@NotBlank(message = "Please select account!")
			String accountFrom,
			String category,
			String accountTo,
			@Min(value = 1, message = "Enter correct ammount!")
			double amount,
			String note,
			LocalDateTime creation
		) {
	

}
