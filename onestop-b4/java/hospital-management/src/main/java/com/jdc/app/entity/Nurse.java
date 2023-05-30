package com.jdc.app.entity;

import javax.persistence.Entity;

@Entity
public class Nurse extends Staff {

	private static final long serialVersionUID = 1L;
	
	public Nurse() {
		setRole(Role.Nurse);
	}

}
