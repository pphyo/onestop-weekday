package com.jdc.app.model.dto;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter @Setter
@NamedQuery(name = "Category.getAll", query = "select c from Category c")
@NamedQuery(name = "Category.getOne", query = "select c from Category c where c.id = :id")
public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@Basic(optional = false)
	@Column(length = 20, unique = true, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> products;

}
