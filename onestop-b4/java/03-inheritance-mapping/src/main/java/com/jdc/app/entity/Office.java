package com.jdc.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "office")
public class Office extends Account {

	private static final long serialVersionUID = 1L;

	private boolean admin;

	public Office() {
	}

	public Office(String username, String loginId, String password, boolean admin) {
		super(username, loginId, password);
		this.admin = admin;
		setRole(Role.Office);
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
