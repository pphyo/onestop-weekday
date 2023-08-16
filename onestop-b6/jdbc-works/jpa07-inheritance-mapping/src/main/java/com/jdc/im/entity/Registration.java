package com.jdc.im.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.MapsId;

@Getter @Setter
@Entity
@Table(name = "registration")
public class Registration {
	
	@EmbeddedId
	private RegistrationPK registrationPK;
	
	@Column(nullable = false, name = "reg_date")
	private LocalDate regDate;
	
	@Column(nullable = false, name = "reg_fee")
	private double regFee;
	
	@ManyToOne
	@MapsId("studentId")
	private Student student;
	
	@ManyToOne
	@MapsId("courseId")
	private Course course;

}
