package com.jdc.jpql;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@Entity
@Table(name = "course")
@NamedQuery(name = "Course.findAll", 
	query = "select c from Course c")
@NamedQuery(name = "Course.findById", 
	query = "select c from Course c where c.id = :id")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 30, name = "course_name")
	private String name;
	
	@Column(nullable = false, name = "course_fees")
	private double fees;
	@Column(nullable = false, name = "course_duration")
	private int duration;
	
	@Column(nullable = false)
	private Level level;
	
	@ElementCollection
	@CollectionTable(name = "objectives", joinColumns = @JoinColumn(name = "course_id"))
	@Column(name = "name")
	private List<String> objectives;
	
	public enum Level {
		Basic, Intermediate, Advanced
	}
	
}
