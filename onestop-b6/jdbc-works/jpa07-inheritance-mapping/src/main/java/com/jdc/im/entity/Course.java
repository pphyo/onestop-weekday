package com.jdc.im.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false)
	private double fee;
	
	@Column(nullable = false)
	private int duration;
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private Level level;
	
	public enum Level {
		Basic, Intermediate, Advanced
	}

}
