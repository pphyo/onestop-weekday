package com.jdc.em.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "account")
@ExcludeDefaultListeners
public class Account extends TimeEnableEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false)
	private int amount;
	
	@PostLoad
	private void afterLoad() {
		System.out.println("After Load");
	}

}