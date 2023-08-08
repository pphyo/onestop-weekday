package com.jdc.pk;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.SequenceGenerator;

@Getter @Setter
@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "STUDENT_SEQ")
	@SequenceGenerator(name = "STUDENT_SEQ")
	private Integer id;
	
	@Column(nullable = false, length = 50)
	private String name;
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	
	public enum Gender {
		Male, Female, Other
	}

}
