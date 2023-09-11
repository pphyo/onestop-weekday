package com.jdc.location.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Division {

	@Id
	@GeneratedValue(generator = "division_seq")
	@SequenceGenerator(name = "division_seq", allocationSize = 1)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private String region;
	@Column(nullable = false)
	private String burmese;
	@Column(nullable = false)
	private String capital;
}
