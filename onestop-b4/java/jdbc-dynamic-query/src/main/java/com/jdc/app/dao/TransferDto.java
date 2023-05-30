package com.jdc.app.dao;

public record TransferDto(
			String courseName,
			String level,
			int courseDuration,
			int fees,
			String moduleName,
			int moduleDuration,
			String description
		) {

}
