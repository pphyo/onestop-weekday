package com.jdc.app.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int amount;
	private LocalDateTime creatAt;
	private LocalDateTime updateAt;
	private LocalDateTime removeAt;
	
	@PostPersist
	public void afterPersist() {
		creatAt = LocalDateTime.now();
	}
	
	@PostUpdate
	public void afterUpdate() {
		updateAt = LocalDateTime.now();
	}

}
