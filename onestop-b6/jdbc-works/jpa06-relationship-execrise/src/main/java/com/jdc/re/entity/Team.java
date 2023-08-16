package com.jdc.re.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "team")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 30)
	private String name;
	@Column(nullable = false)
	private double networth;
	
	@ElementCollection
	@CollectionTable(name = "sponsers", joinColumns = @JoinColumn(name = "team_id"))
	@Column(name = "sponser", length = 100)
	private List<String> sponsers;
	
}
