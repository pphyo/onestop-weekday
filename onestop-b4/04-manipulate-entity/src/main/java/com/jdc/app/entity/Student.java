package com.jdc.app.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@ExcludeDefaultListeners
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 50)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private Gender gender;
	private LocalDate dob;
	
	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	private Address address;

	public Student(String name, Gender gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	public enum Gender {
		Male, Female
	}
	
	@PreUpdate
	public void beforeUpdate() {
		System.out.println("PreUpdate");
	}
	
	@PostUpdate
	public void afterUpdate() {
		System.out.println("PostUpdate");
	}
}
