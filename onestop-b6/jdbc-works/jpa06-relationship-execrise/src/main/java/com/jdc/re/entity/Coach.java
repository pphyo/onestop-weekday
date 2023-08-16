package com.jdc.re.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "coach")
public class Coach implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Crew crew;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CoachType type;
	
	public enum CoachType {
		Head, Assistance
	}
	
}
