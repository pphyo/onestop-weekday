package com.jdc.im.entity;

import static javax.persistence.InheritanceType.JOINED;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

@Getter @Setter
@Entity
@Inheritance(strategy = JOINED)
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 40)
	private String name;
	@Column(nullable = false)
	private double price;

}
