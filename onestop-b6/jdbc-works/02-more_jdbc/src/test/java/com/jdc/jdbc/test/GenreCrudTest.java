package com.jdc.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.jdc.app.model.service.GenreService;

@TestMethodOrder(OrderAnnotation.class)
public class GenreCrudTest {
	
	static GenreService service;
	
	@BeforeAll
	static void setUpBeforeClass() {
		service = new GenreService();
	}
	
	@Order(1)
	@ParameterizedTest
	@MethodSource(value = "getGenreList")
	void test_for_save_multiple_genres(List<String> genreList) {
		service.saveAll(genreList);
		assertEquals(6, service.findAll().size());
	}
	
	static Stream<Arguments> getGenreList() {
		return Stream.of(
				Arguments.of(List.of(
						"Drama", "Historical",
						"Sci-Fi", "Horror",
						"Biography", "Comedy"
						))
				);
	}

}
