package com.jdc.app.model.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "supplier")
@Data
public class Supplier implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false, length = 40)
	private String name;
	@Column(unique = true, nullable = false, length = 40)
	private String email;
	@Column(nullable = false, length = 15)
	private String phone;
	
	@ManyToMany(mappedBy = "suppliers")
	private List<Product> products;

}
