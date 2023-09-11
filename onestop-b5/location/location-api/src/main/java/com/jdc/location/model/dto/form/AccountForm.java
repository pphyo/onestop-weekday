package com.jdc.location.model.dto.form;

import com.jdc.location.model.entity.Account;

import jakarta.validation.constraints.NotBlank;

public record AccountForm(
		@NotBlank(message = "Login Id can't be empty!")
		String loginId,
		@NotBlank(message = "Password cant be empty!")
		String password
		) {
	
	public Account entity() {
		var account = new Account();
		account.setLoginId(loginId);
		account.setPassword(password);
		return account;
	}

}
