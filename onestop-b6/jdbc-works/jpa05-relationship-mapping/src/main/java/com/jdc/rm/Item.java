package com.jdc.rm;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item")
@NoArgsConstructor
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false)
	private double price;
	private boolean deleted;

	@ManyToOne
	private Category category;

	public Item(String name, double price, boolean deleted) {
		super();
		this.name = name;
		this.price = price;
		this.deleted = deleted;
	}

//	@OneToMany
//	@JoinTable(name = "sale_item_join", 
//		joinColumns = @JoinColumn(name = "item_id"),
//		inverseJoinColumns = @JoinColumn(name = "sale_item_id"))
//	private List<SaleItem> saleItems;

}
