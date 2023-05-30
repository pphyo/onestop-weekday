package com.jdc.app.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "registration")
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RegistrationPK id;
	@Column(nullable = false, name = "reg_date")
	private LocalDate regDate;
	private int fees;
	
	@MapsId("studentId")
	@ManyToOne
	private Student student;
	
	@MapsId("classId")
	@ManyToOne
	@JoinColumn(name = "class_id")
	private Clazz clazz;

	public RegistrationPK getId() {
		return id;
	}

	public void setId(RegistrationPK id) {
		this.id = id;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

}
