package com.jdc.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Inheritance
@Entity
@Table(name = "staff")
@DiscriminatorColumn(name = "staff_role")
@Getter
@Setter
public abstract class Staff implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 100)
	private String name;
	private String degree;
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToOne
	private Department department;
	
	@OneToOne(optional = false)
	private Contact contact;

}
