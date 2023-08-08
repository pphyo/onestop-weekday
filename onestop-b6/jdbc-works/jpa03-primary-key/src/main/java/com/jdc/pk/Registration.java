package com.jdc.pk;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "registration")
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegistrationPK registrationPK;
	
	@Column(name = "reg_date")
	private LocalDate regDate;	
	@Column(name = "reg_fee")
	private double regFee;

	public Registration() {
		registrationPK = new RegistrationPK();
	}
	
}
