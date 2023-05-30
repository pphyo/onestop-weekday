package com.jdc.app.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "INVOICE")
@Table(name = "invoice")
@Getter @Setter
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, name = "inv_date")
	private LocalDate invoiceDate;
	@Column(nullable = false, name = "inv_time")
	private LocalTime invoiceTime;
	private int tax;
	
	@PostPersist
	public void afterInsert() {
		invoiceDate = LocalDate.now();
		invoiceTime = LocalTime.now();
	}

}
