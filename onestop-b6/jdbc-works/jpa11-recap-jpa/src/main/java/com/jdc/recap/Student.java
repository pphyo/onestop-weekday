package com.jdc.recap;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Table(name = "student")
@Entity
@DiscriminatorValue("Student")
public class Student extends Member {

	private static final long serialVersionUID = 1L;

	public Student() {
		super(Role.Student);
	}
	
}








