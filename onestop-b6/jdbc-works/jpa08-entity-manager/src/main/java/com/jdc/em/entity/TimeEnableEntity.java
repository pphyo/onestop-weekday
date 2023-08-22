package com.jdc.em.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TimeEnableEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime creation;
	private LocalDateTime modification;

}
