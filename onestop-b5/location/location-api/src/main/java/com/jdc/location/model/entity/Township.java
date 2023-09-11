package com.jdc.location.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Township {
	
	@Id
	@GeneratedValue(generator = "township_seq")
	@SequenceGenerator(name = "township_seq", allocationSize = 1)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private String burmese;
	
	@ManyToOne(optional = false)
	private Division division;

}
