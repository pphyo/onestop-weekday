package com.jdc.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_tbl")
@SecondaryTables({
	@SecondaryTable(name = "auth_tbl"),
	@SecondaryTable(name = "user_info")
})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", initialValue = 50)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(table = "user_info")
	private Gender gender;
	
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(table = "user_info")
	private LocalDateTime dob;
	
	@Column(table = "auth_tbl")
	private Authority auth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public Authority getAuth() {
		return auth;
	}

	public void setAuth(Authority auth) {
		this.auth = auth;
	}
	
	public enum Gender {
		Male, Female, Other
	}

}
