package com.jdc.cm;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	@CollectionTable(name = "lessons", 
		joinColumns = @JoinColumn(name = "course_id"), foreignKey = @ForeignKey(name = "course_lesson_fk", foreignKeyDefinition = "foreign key(course_id) references course(id) on delete cascade"))
	@Column(name = "lesson", length = 100, nullable = false)
	private Set<String> lessons;

	@ElementCollection
	@CollectionTable(name = "ratings", joinColumns = @JoinColumn(name = "course_id"))
	@Column(nullable = false, name = "rating")
	@MapKeyColumn(name = "key_column", length = 30)
	private Map<String, Integer> ratings;

	@ElementCollection
	@CollectionTable(name = "course_item", joinColumns = @JoinColumn(name = "course_id"))
	private List<CourseItem> items;
//	private CourseItem courseItem;

	public enum Level {
		Basic, Intermediate, Advanced, Professional
	}
}