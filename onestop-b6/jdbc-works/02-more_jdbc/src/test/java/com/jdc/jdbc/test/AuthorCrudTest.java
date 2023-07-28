package com.jdc.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.app.model.entity.Author.Gender;
import com.jdc.app.model.service.AuthorService;

public class AuthorCrudTest {
	
	AuthorService service = new AuthorService();

	@ParameterizedTest
	@CsvSource({
		",geogre@artist.com,,true",
		",,091929020,true",
		",sirina@gmail.com,0212939933,true",
		",admin@gmail.com,03939393,false"
	})
	void test(Gender gender, String email, String phone, boolean found) {
		var author = service.find(gender, email, phone);
		assertEquals(found, null == author ? false : true);
	}
	
	@ParameterizedTest
	@CsvSource("Anonymous,Other,,00000000")
	void test_for_find_with_no_paramter(String name, Gender gender, String email, String phone) {
		var author = service.find(null, null, null);
		
		assertAll(new Executable() {
			@Override
			public void execute() throws Throwable {
				assertNotNull(author);
				assertEquals(name, author.getName());
				assertEquals(gender, author.getGender());
				assertEquals(email, author.getEmail());
				assertEquals(phone, author.getPhone());
			}
		});
	}
	
}
