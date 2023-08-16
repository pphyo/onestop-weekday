package com.jdc.im.entity;

import java.time.MonthDay;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "book")
public class Book extends Product {
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private MonthDay releasedDate;
	@Column(nullable = false, length = 10)
	private String isbn;

}