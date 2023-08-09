package com.jdc.cm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CourseItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String item;
	@Column(name = "qty")
	private int quantity;
	@Column(name = "unit_price")
	private double unitPrice;
	private double total;
	private int tax;
	
//	@ElementCollection
//	@CollectionTable(name = "descriptions", joinColumns = @JoinColumn(name = "course_id"))
//	@Column(name = "description")
//	@Lob
//	private List<String> descriptions;

}
