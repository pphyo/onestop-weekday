package com.jdc.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher extends Account {

	private static final long serialVersionUID = 1L;
	
	public Teacher() {}

	public Teacher(String username, String loginId, String password) {
		super(username, loginId, password);
		setRole(Role.Teacher);
	}
	
}
