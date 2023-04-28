package com.jdc.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "order_tbl")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private OrderPK id;
	@Column(name = "sub_total", nullable = false)
	private double subTotal;
	@Column(nullable = false)
	private float tax;
	@Column(nullable = false)
	private float discount;
	@SuppressWarnings("unused")
	private double total;
	private char grade;
	private boolean stock;
	
	@Transient
	private boolean deleted;

	public OrderPK getId() {
		return id;
	}

	public void setId(OrderPK id) {
		this.id = id;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@Column(nullable = false)
	public double getTotal() {
		return (subTotal - discount) * tax;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
