package com.jdc.app.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "SALE_ORDER")
@Table(name = "sale_order")
@Getter @Setter
public class SaleOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private int qty;
	@Column(nullable = false, name = "unit_price")
	private int unitPrice;
	
	@ManyToOne(optional = false)
	private Product product;
	
	@ManyToOne
	private Invoice invoice;
	
}
