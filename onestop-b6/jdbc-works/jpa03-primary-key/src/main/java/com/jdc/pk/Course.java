package com.jdc.pk;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.SequenceGenerator;

@Getter @Setter
@Entity
@Table(name = "course")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "COURSE_SEQ")
	@SequenceGenerator(name = "COURSE_SEQ")
	private Integer id;
	
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private int duration;
	@Lob
	private String remark;
	

}







