package com.jdc.app;

import javax.persistence.Persistence;

import com.jdc.app.dao.AppService;

public class HospitalApp {

	public static void main(String[] args) {
		
		var emf = Persistence.createEntityManagerFactory("hospmgmt");
		
		var em = emf.createEntityManager();
		
		AppService service = new AppService(em);
		
		service.insertData();
		
		service.getEm().close();
		emf.close();

	}

}
