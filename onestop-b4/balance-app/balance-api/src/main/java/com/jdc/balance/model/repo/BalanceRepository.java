package com.jdc.balance.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.balance.model.entity.Balance;
import com.jdc.balance.model.entity.Balance.BalanceType;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {

	@Query(value = """
			select sum(b.amount) from Balance b where type = :type
			""")
	Optional<Double> findTotalExpense(BalanceType type);

}
