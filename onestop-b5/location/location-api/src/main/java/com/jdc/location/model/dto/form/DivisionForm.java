package com.jdc.location.model.dto.form;

import com.jdc.location.model.entity.Division;

import jakarta.validation.constraints.NotBlank;

public record DivisionForm(
		@NotBlank(message = "Please enter division name.")
		String name,
		@NotBlank(message = "Please enter burmese name.")
		String burmese,
		@NotBlank(message = "Please enter region name.")
		String region,
		@NotBlank(message = "Please enter capital name.")
		String capital
		) {

	public Division entity() {
		var entity = new Division();
		entity.setName(name);
		entity.setBurmese(burmese);
		entity.setRegion(region);
		entity.setCapital(capital);
		return entity;
	}

}
