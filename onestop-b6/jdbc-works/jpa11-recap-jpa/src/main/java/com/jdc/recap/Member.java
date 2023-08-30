package com.jdc.recap;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Table(name = "member")
@Entity
@NoArgsConstructor
@Inheritance
public class Member extends Account {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "regist_at")
	private LocalDate registAt;
	private String phone;
	@Column(name = "profile_image")
	private String profileImage;
	
	public Member(Role role) {
		super(role);
	}

}