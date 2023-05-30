package com.jdc.app.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LoginInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_name", unique = true, nullable = false, length = 50)
	private String username;
	@Column(nullable = false, length = 50)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(columnDefinition = "LONGTEXT")
	private String remark;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, remark, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginInfo other = (LoginInfo) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(remark, other.remark) && Objects.equals(username, other.username);
	}

}
