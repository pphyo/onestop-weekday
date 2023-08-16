package com.jdc.im.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "electric")
public class Electric extends Product {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 40)
	private String model;
	private int volt;
	
}
