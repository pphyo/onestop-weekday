package com.jdc.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@ExcludeDefaultListeners
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String address;

	public Address(String street, String address) {
		super();
		this.street = street;
		this.address = address;
	}
	
	@PrePersist
	public void beforeInsert() {
		System.out.println("PrePersist");
	}
	
	@PostPersist
	public void afterInsert() {
		System.out.println("PostPersist");
	}

}
