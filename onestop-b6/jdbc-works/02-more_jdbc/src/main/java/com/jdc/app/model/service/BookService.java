package com.jdc.app.model.service;

import static com.jdc.app.model.util.DbManager.getConnection;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdc.app.model.entity.Author;
import com.jdc.app.model.entity.Book;

public class BookService {
	
	private AuthorService service;
	
	public BookService() {
		service = new AuthorService();
	}
	
	/**
	 * @author pphyo
	 * @param book
	 * @return generated id
	 */

	public int save(Book book) {
				
		final String BOOK_INSERT = """
				insert into books (title, isbn, price, published_date,
				genre_id, author_id) values (?, ?, ?, ?, ?, ?)
				""";
		final String AUTHOR_INSERT = """
				insert into authors (name, gender, email, phone) values (?, ?, ?, ?)
				""";
		
		Author author = service.find(book.getAuthor().getGender(),
				book.getAuthor().getEmail(), 
				book.getAuthor().getPhone());		
		
		try(var conn = getConnection();
				var bookStmt = conn.prepareStatement(BOOK_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			
			bookStmt.setString(1, book.getTitle());
			bookStmt.setString(2, book.getIsbn());
			bookStmt.setDouble(3, book.getPrice());
			bookStmt.setDate(4, Date.valueOf(book.getPublishedDate()));
			bookStmt.setInt(5, book.getGenre().getId());
			
			
			if(null == author) {
				
				int authorId = 1;
				
				// try start
				try(var authorStmt = conn.prepareStatement(AUTHOR_INSERT, Statement.RETURN_GENERATED_KEYS)) {
					
					authorStmt.setString(1, book.getAuthor().getName());
					authorStmt.setString(2, book.getAuthor().getGender().name());
					authorStmt.setString(3, book.getAuthor().getEmail());
					authorStmt.setString(4, book.getAuthor().getPhone());
					
					authorStmt.executeUpdate();
					
					var rs = authorStmt.getGeneratedKeys();
					
					while(rs.next())
						authorId = rs.getInt(1);
					
				}
				// try end
				
				bookStmt.setInt(6, authorId);
				
			} else {
				bookStmt.setInt(6, author.getId());
			}
			
			bookStmt.executeUpdate();
			
			var rs = bookStmt.getGeneratedKeys();
			
			while(rs.next())
				return rs.getInt(1);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
