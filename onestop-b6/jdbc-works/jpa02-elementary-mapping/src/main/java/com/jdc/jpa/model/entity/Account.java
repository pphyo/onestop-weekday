package com.jdc.jpa.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNT")
@SecondaryTables({
	@SecondaryTable(name = "account_info",
			uniqueConstraints = {
					@UniqueConstraint(columnNames = "login_id")
					},
			indexes = @Index(columnList = "login_id")),
	@SecondaryTable(name = "account_credential")
})
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(nullable = false, name = "login_id", table = "account_info")
	private String loginId;
	@Column(nullable = false, 
			table = "account_credential",
			columnDefinition = "varchar(50) check(char_length(password) >= 5)")
	private String password;
	@Column(nullable = false, unique = true, 
			table = "account_info", length = 50)
	private String username;
	@Column(columnDefinition = "boolean")
	private boolean active;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private Role role;
	
	private Security security;
	
	public enum Role {
		Admin, Teacher, Student
	}

}
