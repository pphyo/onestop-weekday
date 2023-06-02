package com.jdc.balance.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BALANCE")
@Data
public class Balance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BalanceType type;
	private double amount;
	@Column(name = "issued_at")
	private LocalDateTime issuedAt;
	
	@ManyToMany
	@JoinTable(name = "balance_category", inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;
	
	@ManyToMany
	@JoinTable(name = "balance_account", inverseJoinColumns = @JoinColumn(name = "account_id"))
	private List<Account> accounts;
	
	public Balance() {
		type = BalanceType.Expense;
		issuedAt = LocalDateTime.now();
	}
	
	public enum BalanceType {
		Income, Expense, Tranfser
	}

}