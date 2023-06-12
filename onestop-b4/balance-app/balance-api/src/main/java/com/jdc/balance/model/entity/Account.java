package com.jdc.balance.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ACCOUNT")
@SequenceGenerator(name = "ACCOUNT_SEQ")
@Data
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "ACCOUNT_SEQ")
	private int id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(name = "initial_amount")
	private double initialAmount;
	private String icon;
	
}