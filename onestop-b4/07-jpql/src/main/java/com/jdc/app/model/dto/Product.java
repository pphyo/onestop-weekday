package com.jdc.app.model.dto;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@Column(nullable = false, length = 50)
	private String name;
	
	@ElementCollection
	@CollectionTable(name = "remark", joinColumns = @JoinColumn(name = "product_id"))
	private List<String> remarks;
	
	@ManyToOne(optional = false)
	private Category category;
	
	@ManyToMany
	@JoinTable(name = "product_supply",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "supplier_id"))
	private List<Supplier> suppliers;

}
