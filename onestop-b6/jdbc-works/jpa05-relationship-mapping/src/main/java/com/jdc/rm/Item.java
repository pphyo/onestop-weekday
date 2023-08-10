package com.jdc.rm;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "item")
public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	@Column(nullable = true, length = 50)
	private String name;
	@Column(nullable = true)
	private double price;
	private boolean deleted;
	
	@ManyToOne
	@JoinTable(name = "item_category")
	private Category category;
	
	@OneToMany
	@JoinTable(name = "sale_item_join", 
		joinColumns = @JoinColumn(name = "item_id"),
		inverseJoinColumns = @JoinColumn(name = "sale_item_id"))
	private List<SaleItem> saleItems;

}