package com.jdc.balance.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BUDGET")
@Data
public class Budget implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(nullable = false, name = "limit_amount")
	private double limitAmount;
	private double spent;
	private double remaining;
	
	@MapsId
	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Category category;

}
