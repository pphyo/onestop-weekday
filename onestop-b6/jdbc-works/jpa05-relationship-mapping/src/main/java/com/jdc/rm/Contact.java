package com.jdc.rm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "contact")
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 40, unique = true)
	private String email;
	
	@Column(nullable = false, length = 15)
	private String phone;
	
	@OneToOne
	private Customer customer;
	
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//		customer.setContact(this);
//	}

}






