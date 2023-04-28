package com.jdc.app.dao;

import java.util.Collections;

import javax.persistence.EntityManager;

import com.jdc.app.entity.Department;
import com.jdc.app.entity.Hospital;

public class AppService {
	
	private EntityManager em;
	
	public AppService(EntityManager em) {
		this.em = em;
	}
	
	public void insertData() {
		em.getTransaction().begin();
		
		Department dep1 = new Department();
		dep1.setName("Hospital Management");
		
		Department dep2 = new Department();
		dep2.setName("Cashier");
		
		Department dep3 = new Department();
		dep3.setName("Office");
		
		Department dep4 = new Department();
		dep4.setName("Emergency");
		
		Hospital hosp = new Hospital();
		hosp.setName("San Ga Hospital");
		Collections.addAll(hosp.getDepartments(), dep1, dep2, dep3, dep4);
		// one to many
		hosp.setDepartments(hosp.getDepartments());
		
		em.persist(dep1);
		em.persist(dep2);
		em.persist(dep3);
		em.persist(dep4);
		
		em.persist(hosp);
		
		em.getTransaction().commit();
		
	}

	public EntityManager getEm() {
		return em;
	}
}
