package com.jdc.recap;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "teacher")
@DiscriminatorValue("Teacher")
public class Teacher extends Member {

	private static final long serialVersionUID = 1L;

	public Teacher() {
		super(Role.Teacher);
	}
	
}
