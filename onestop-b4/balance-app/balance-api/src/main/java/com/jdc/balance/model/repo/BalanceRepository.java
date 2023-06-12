
package com.jdc.balance.model.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.balance.model.dto.BalanceListDto;
import com.jdc.balance.model.entity.Balance;
import com.jdc.balance.model.entity.Balance.BalanceType;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {

	@Query(value = "select sum(b.amount) from Balance b where type = :type")
	Optional<Double> findTotalExpense(BalanceType type);
	
	@Query(value = "select b.createdAt from Balance b")
	List<LocalDateTime> findDaysInMonth();
	
	@Query(value = """
			select NEW com.jdc.balance.model.dto.BalanceListDto(b.id, b.createdAt, b.type, 
			b.amount, b.category.name, b.category.icon, b.accountFrom.name, b.accountFrom.icon,
			b.accountTo.name, b.accountTo.icon, b.note) from Balance b join b.accountFrom
			left join b.accountTo left join b.category
			""")
	List<BalanceListDto> getBalanceInMonth();

}
