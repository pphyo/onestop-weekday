package com.jdc.im.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "funiture")
//@PrimaryKeyJoinColumn(name = "funiture_id")
public class Funiture extends Product {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private MadeType madeType;
	
	public enum MadeType {
		Wood, Steel, Iron
	}
	
}
