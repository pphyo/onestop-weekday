package com.jdc.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.app.model.entity.Author;
import com.jdc.app.model.entity.Author.Gender;
import com.jdc.app.model.entity.Book;
import com.jdc.app.model.entity.Genre;
import com.jdc.app.model.service.BookService;

public class LibraryCrudTest {
	
	BookService service = new BookService();
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test(int id) {
		
		Book book = new Book();
		book.setTitle("Harry Potter");
		book.setIsbn("BK-1001911");
		book.setPrice(55.8);
		book.setPublishedDate(LocalDate.of(1997, 5, 10));
		
		Genre genre = new Genre();
		genre.setId(4);
		book.setGenre(genre);
		
		Author author = new Author();
		author.setName("JK rowling");
		author.setGender(Gender.Female);
		author.setEmail("jkrowling@harrypotter.com");
		author.setPhone("012100101");
		
		book.setAuthor(author);
		
		int generatedId = service.save(book);
		
		assertEquals(id, generatedId);
	}

}
