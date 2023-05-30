package com.jdc.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter @Setter
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false)
	private int price;
	private int stock;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private Size size = Size.MEDIUM;
	@ElementCollection
	@CollectionTable(name = "remarks", joinColumns = @JoinColumn(name = "product_id"))
	@Column(name = "remark")
	private List<String> remarks;
	
	@ManyToOne(optional = false)
	private Category category;

	public enum Size {
		SMALL, MEDIUM, LARGE, EXTRALARGE
	}
	
}
