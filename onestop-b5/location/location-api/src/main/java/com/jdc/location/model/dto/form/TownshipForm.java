package com.jdc.location.model.dto.form;

import java.util.Optional;
import java.util.function.Function;

import com.jdc.location.model.LocationBusinessException;
import com.jdc.location.model.entity.Division;
import com.jdc.location.model.entity.Township;

import jakarta.validation.constraints.NotBlank;

public record TownshipForm(
		@NotBlank(message = "Please enter township name.") String name,
		@NotBlank(message = "Please enter burmese name.") String burmese, 
		int divisionId) {

	public Township entity(Function<Integer, Optional<Division>> divisionResolver) {
		var entity = new Township();
		entity.setName(name);
		entity.setBurmese(burmese);
		entity.setDivision(divisionResolver.apply(divisionId).orElseThrow(
				() -> new LocationBusinessException("There is no division with id %d.".formatted(divisionId))));
		return entity;
	}
}
