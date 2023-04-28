package com.jdc.app.entity;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Getter @Setter
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BookingPK id;
	@Column(nullable = false, name = "check_in_time")
	private LocalTime checkInTime;

	@OneToOne(optional = false)
	private Patient patient;

}
