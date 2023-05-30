package com.jdc.app.entity;

import java.awt.Color;
import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jdc.app.convert.ColorConverter;

@Entity
@Table(name = "student")
public class Student extends Account {

	private static final long serialVersionUID = 1L;

	private LocalDate dob;
	@Convert(converter = ColorConverter.class)
	private Color color;
	
	private Contact contact;
	
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name = "sec_phone"), name = "phone"),
		@AttributeOverride(column = @Column(name = "sec_email"), name = "email"),
		@AttributeOverride(column = @Column(name = "sec_address"), name = "address")
	})
	private Contact secondary;

	public Student() {
	}

	public Student(String username, String loginId, String password) {
		super(username, loginId, password);
		setRole(Role.Student);
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getSecondary() {
		return secondary;
	}

	public void setSecondary(Contact secondary) {
		this.secondary = secondary;
	}

}
