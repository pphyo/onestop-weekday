package com.jdc.re.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "player")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Crew crew;
	@Column(nullable = false)
	private double weight;
	@Column(nullable = false)
	private double height;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	public enum Role {
		Attacker, MiddleFielder, Defender, GoalKeeper
	}

}
