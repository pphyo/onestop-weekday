package com.jdc.rm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 40)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToOne(mappedBy = "customer")
	private Contact contact;
	
	public enum Gender {
		Male, Female
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
		contact.setCustomer(this);
	}

}





