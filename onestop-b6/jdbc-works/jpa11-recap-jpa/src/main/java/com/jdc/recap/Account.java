package com.jdc.recap;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Table(name = "account")
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Inheritance
@DiscriminatorColumn(name = "ACC_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String username;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;
	
	private boolean deleted;
	
	@Enumerated(EnumType.STRING)
	@NonNull
	private Role role;
	
	public enum Role {
		Admin, Teacher, Student
	}

}