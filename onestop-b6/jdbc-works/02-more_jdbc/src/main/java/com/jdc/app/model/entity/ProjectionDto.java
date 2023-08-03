package com.jdc.app.model.entity;

import java.time.LocalDate;

import com.jdc.app.model.entity.Author.Gender;

public record ProjectionDto(
		String title,
		String isbn,
		double price,
		LocalDate publishedDate,
		String genreName,
		String authorName,
		Gender gender,
		String email,
		String phone
		) {

}
