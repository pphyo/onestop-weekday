package com.jdc.rm;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.JoinColumn;

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
	
	@ManyToOne(optional = false)
	@JoinTable(name = "item_category", 
		joinColumns = @JoinColumn(name = "item_id"),
		inverseJoinColumns = @JoinColumn(name = "cat_id"))
	private Category category;

}










