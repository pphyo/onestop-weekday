package com.jdc.cm;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
	private Integer id;

	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false)
	private double price;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private Level level = Level.Intermediate;
	
	@ElementCollection
	private List<String> lessons;
	
	public enum Level {
		Basic, Intermediate, Advanced, Professional
	}
}
