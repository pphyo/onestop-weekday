package com.jdc.location.model.dto;

import com.jdc.location.model.entity.Township;

public record TownshipDTO(
	int id,
	String name,
	String burmese,
	DivisionDTO division
		) {

	public static TownshipDTO from(Township entity) {
		return new TownshipDTO(entity.getId(), 
				entity.getName(), 
				entity.getBurmese(), 
				DivisionDTO.from(entity.getDivision()));
	}
}
