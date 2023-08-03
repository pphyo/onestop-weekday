package com.jdc.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.app.model.entity.Author;
import com.jdc.app.model.entity.Author.Gender;
import com.jdc.app.model.entity.Book;
import com.jdc.app.model.entity.Genre;
import com.jdc.app.model.service.BookService;

public class LibraryCrudTest {
	
	BookService service = new BookService();
	
	@ParameterizedTest
	@ValueSource(ints = 8)
	void test(int id) {
		
		Book book = new Book();
		book.setTitle("Hla Taw Thar");
		book.setIsbn("BK-100684993");
		book.setPrice(10.2);
		book.setPublishedDate(LocalDate.of(2000, 10, 11));
		
		Genre genre = new Genre();
		genre.setId(6);
		book.setGenre(genre);
		
		Author author = new Author();
		author.setName("Lel Twin Thar Saw Chit");
		author.setGender(Gender.Male);
		author.setEmail("sawchit@hlatawthar.com");
		author.setPhone("09292828833");
		
		book.setAuthor(author);
		
		int generatedId = service.save(book);

		assertEquals(id, generatedId);
	}
	
	@ParameterizedTest
	@CsvSource({
		",0,,Horror,,2",
		",50,2000-01-01,,,2"
	})
	void test_for_book_search(String title, double price, LocalDate publishedDate, String genreName, String authorName, int resultSize) {
		var list = service.search(title, price, publishedDate, genreName, authorName);
		assertEquals(resultSize, list.size());
	} 

}
