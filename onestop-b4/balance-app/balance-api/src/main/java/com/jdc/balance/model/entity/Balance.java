package com.jdc.balance.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BALANCE")
@SequenceGenerator(name = "BALANCE_SEQ")
@Data
public class Balance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "BALANCE_SEQ")
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private BalanceType type;
	private double amount;
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	private String note;
		
	@ManyToOne(optional = false)
	@JoinColumn(name = "from_account_id")
	private Account accountFrom;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "to_account_id")
	private Account accountTo;

	
	public Balance() {
		createdAt = LocalDateTime.now();
	}
	
	public enum BalanceType {
		Income, Expense, Transfer
	}

}