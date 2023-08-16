package com.jdc.re.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Crew implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private double wage;
	
}
