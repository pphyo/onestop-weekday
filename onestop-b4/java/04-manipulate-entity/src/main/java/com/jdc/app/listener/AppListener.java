package com.jdc.app.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AppListener {
	
	@PrePersist
	public void beforeInsert(Object obj) {
		System.out.println("PrePersist in AppListener");
	}
	
	@PreUpdate
	public void beforeUpdate(Object obj) {
		System.out.println("PreUpdate in AppListener");
	}

}
