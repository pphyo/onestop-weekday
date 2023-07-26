package com.jdc.jdbc.model.domain;

import java.time.LocalDateTime;

public class User {

	private int id;
	private String username;
	private String email;
	private String password;
	private LocalDateTime creation;

	public User(int id, String username, String email, String password, LocalDateTime creation) {
		this(username, email, password, creation);
		this.id = id;
	}

	public User(String username, String email, String password, LocalDateTime creation) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.creation = creation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

}
