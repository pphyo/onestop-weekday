package com.jdc.app.dao;

public record Course(
			String code,
			String name,
			String level,
			int duration,
			int fees
		) {

}
