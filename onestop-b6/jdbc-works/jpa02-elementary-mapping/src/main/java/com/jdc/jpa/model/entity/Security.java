package com.jdc.jpa.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Security implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition = "timestamp")
	private LocalDateTime creation;
	private LocalDateTime modification;
	private int flag;
	private String problem;
	
}
