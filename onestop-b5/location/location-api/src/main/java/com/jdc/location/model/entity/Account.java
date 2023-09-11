package com.jdc.location.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Account {
	
	@Id
	@GeneratedValue(generator = "account_seq")
	@SequenceGenerator(name = "account_seq", allocationSize = 1)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String loginId;
	@Column(nullable = false)
	private String password;

}
