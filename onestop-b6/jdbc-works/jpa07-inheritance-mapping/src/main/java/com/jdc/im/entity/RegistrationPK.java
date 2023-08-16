package com.jdc.im.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class RegistrationPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "student_id")
	private int studentId;
	@Column(name = "course_id")
	private int courseId;

}