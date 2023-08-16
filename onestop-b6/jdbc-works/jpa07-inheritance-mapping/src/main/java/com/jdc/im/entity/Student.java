package com.jdc.im.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@AttributeOverride(name = "address", column = @Column(name = "primary_address"))		
	@AttributeOverride(name = "phone", column = @Column(name = "primary_phone")) 
	private Address primaryAddress;
	private Address address;
	
	public enum Gender {
		Male, Female, Other
	}
	
}
