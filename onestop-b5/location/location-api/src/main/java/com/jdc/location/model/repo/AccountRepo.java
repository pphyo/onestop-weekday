package com.jdc.location.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.location.model.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

	Optional<Account> findByLoginId(String loginId);
	
}
