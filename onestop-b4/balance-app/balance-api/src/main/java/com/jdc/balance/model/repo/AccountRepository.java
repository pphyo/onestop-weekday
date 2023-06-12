package com.jdc.balance.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.balance.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query("select sum(a.initialAmount) from Account a")
	Optional<Long> getTotalAmount();
	
	Optional<Account> findByName(String name);
	
}
