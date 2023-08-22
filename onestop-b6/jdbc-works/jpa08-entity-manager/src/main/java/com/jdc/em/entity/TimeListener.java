package com.jdc.em.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class TimeListener {

	@PrePersist
	private void beforePersist(Object obj) {
		System.out.println("beforePersist()");
	}
	
	@PreUpdate
	private void beforeUpate(Object obj) {
		System.out.println("beforeUpate()");
	}
	
}
