package com.jdc.rm;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sale")
public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate saleDate;
	@Column(nullable = false)
	private double total;
	private String remark;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items;

	public Sale(LocalDate saleDate, double total, String remark) {
		super();
		items = new ArrayList<>();
		this.saleDate = saleDate;
		this.total = total;
		this.remark = remark;
	}

	public Sale() {
		items = new ArrayList<>();
	}

}
