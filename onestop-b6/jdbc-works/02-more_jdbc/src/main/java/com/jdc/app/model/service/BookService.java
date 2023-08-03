package com.jdc.app.model.service;

import static com.jdc.app.model.util.DbManager.getConnection;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jdc.app.model.entity.Author;
import com.jdc.app.model.entity.Author.Gender;
import com.jdc.app.model.entity.Book;
import com.jdc.app.model.entity.ProjectionDto;
import com.jdc.app.model.util.StringUtil;

public class BookService {
	
	private AuthorService service;
	
	public BookService() {
		service = new AuthorService();
	}
	
	public List<ProjectionDto> search(String title, double price, LocalDate publishedDate, String genreName, String authorName) {
		
		final String sql = """
				select b.title, b.isbn, b.price, b.published_date,
				g.name genre_name, a.name author_name, a.gender,
				a.email, a.phone from books b join genres g
				on b.genre_id = g.id join authors a
				on b.author_id = a.id where 1 = 1
				""";
		
		List<ProjectionDto> result = new ArrayList<>();
		List<Object> params = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder(sql);
		
		if(!StringUtil.isEmpty(title)) {
			sb.append(" and b.title like ?");
			params.add(title.concat("%"));
		}
		
		if(price > 0) {
			sb.append(" and b.price >= ?");
			params.add(price);
		}
		
		if(null != publishedDate) {
			sb.append(" and b.published_date >= ?");
			params.add(publishedDate);
		}
		
		if(!StringUtil.isEmpty(genreName)) {
			sb.append(" and g.name like ?");
			params.add(genreName.concat("%"));
		}
		
		if(!StringUtil.isEmpty(authorName)) {
			sb.append(" and a.name like ?");
			params.add(authorName.concat("%"));
		}
		
		try(var conn = getConnection();
				var stmt = conn.prepareStatement(sb.toString())) {
			
			for(int i = 0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				result.add(new ProjectionDto(
						rs.getString("title"), 
						rs.getString("isbn"), 
						rs.getDouble("price"), 
						rs.getDate("published_date").toLocalDate(), 
						rs.getString("genre_name"), 
						rs.getString("author_name"), 
						Gender.valueOf(rs.getString("gender")), 
						rs.getString("email"), 
						rs.getString("phone")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
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
			
			conn.setAutoCommit(false);
			
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
			conn.commit();
			
			var rs = bookStmt.getGeneratedKeys();
			
			while(rs.next())
				return rs.getInt(1);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
