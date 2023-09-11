package com.jdc.location.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.LocationBusinessException;
import com.jdc.location.model.dto.AccountDTO;
import com.jdc.location.model.dto.form.AccountForm;
import com.jdc.location.model.repo.AccountRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	
	private final AccountRepo repo;
	
	@Transactional
	public AccountDTO create(AccountForm form) {
		return AccountDTO.from(repo.save(form.entity()));
	}
	
	public AccountDTO findByLoginId(String loginId, String password) {
		return AccountDTO.from(
				repo.findByLoginId(loginId).orElseThrow(() -> {
					throw new LocationBusinessException("No account found with %s".formatted(loginId));
				})
				);
	}

}