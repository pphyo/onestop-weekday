package com.jdc.location.model.dto;

import com.jdc.location.model.entity.Division;

public record DivisionDTO(
		int id,
		String name,
		String burmese,
		String region,
		String capital
		) {

	public static DivisionDTO from(Division entity) {
		return new DivisionDTO(entity.getId(), 
				entity.getName(), 
				entity.getBurmese(), 
				entity.getRegion(), 
				entity.getCapital());
	}

}
