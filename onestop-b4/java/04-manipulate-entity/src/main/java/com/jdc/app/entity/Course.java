package com.jdc.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "course")
@Getter @Setter @NoArgsConstructor
//@EntityListeners(AppListener.class)
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int fees;
	private int duration;
	
	public Course(String name, int fees, int duration) {
		super();
		this.name = name;
		this.fees = fees;
		this.duration = duration;
	}
	
}
