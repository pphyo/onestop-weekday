package com.jdc.jpql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false)
	private double fees;
	@Column(nullable = false)
	private int duration;
	
	@Column(nullable = false)
	private Level level;
	
	public enum Level {
		Basic, Intermediate, Advanced
	}
	
}
