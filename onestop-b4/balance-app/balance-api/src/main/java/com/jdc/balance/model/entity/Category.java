package com.jdc.balance.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CATEGORY")
@SequenceGenerator(name = "CATEGORY_SEQ")
@Data
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "CATEGORY_SEQ")
	private int id;
	@Column(nullable = false, unique = true)
	private String name;
	@Enumerated(EnumType.STRING)
	private CategoryType type;
	private String icon;
		
	public enum CategoryType {
		Income, Expense
	}

}