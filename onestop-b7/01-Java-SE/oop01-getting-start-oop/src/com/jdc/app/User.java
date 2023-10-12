package com.jdc.app;

import java.util.Objects;

public class User extends Object {

	public static int id;
	private String name;
	private int age;
	private String phone;

	public User() {
		System.out.println(toString());
		System.out.println("User Default Constructor");
	}

	public User(String name, int age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		System.out.println("Constructor Using Fields");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	public void ageUp() {
		age++;
	}

}
