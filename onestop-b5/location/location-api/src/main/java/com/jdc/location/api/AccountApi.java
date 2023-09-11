package com.jdc.location.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.location.model.dto.AccountDTO;
import com.jdc.location.model.dto.form.AccountForm;
import com.jdc.location.model.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountApi {
	
	private final AccountService service;

	@GetMapping("sign-in")
	AccountDTO signIn(@RequestParam String loginId, @RequestParam String password) {
		return service.findByLoginId(loginId, password);
	}
	
	@PostMapping("sign-up")
	AccountDTO signUp(@Validated @RequestBody AccountForm form) {
		return service.create(form);
	}
	
}
