package com.jdc.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import javax.persistence.Column;

@Data
@Embeddable
public class RegistrationPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "course_id")
	private Integer courseId;
	@Column(name = "student_id")
	private Integer studentId;

}
