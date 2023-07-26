package com.jdc.jdbc.model.dao;

import static com.jdc.jdbc.model.util.DbUtil.getConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jdc.jdbc.model.domain.User;

public class UserDao {
		
	private static final String INSERT = """
			insert into users (username, email, password, creation) values
			(?, ?, ?, ?)
			""";
//	private static final String COUNT = """
//			select count(*) as result from users
//			""";
	private static final String SELECT = """
			select * from users
			""";
	private static final String DELETE = """
			delete from users where id = ?
			""";
	private static final String UPDATE = """
			update users set username = ?, email = ?, password = ?,
			creation = ? where id = ?
			""";
	
	public List<User> findAll() {
		
		List<User> result = new ArrayList<>();
		
		try(var conn = getConnection();
				var stmt = conn.createStatement()) {
			
			var rs = stmt.executeQuery(SELECT);
			
			// check data to next record
			
			while(rs.next()) {
				result.add(getUser(rs));
			}
				// if data exists, get row value given the column name or index
//				var id = rs.getInt("id");
//				var username = rs.getString("username");
//				var email = rs.getString("email");
//				var password = rs.getString("password");
//				var creation = rs.getTimestamp("creation").toLocalDateTime();
				
				// convert to user object
//				var user = new User(id, username, email, password, creation);
				// add to list
				// return the list
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public void update(User user) {
		
		assert(user.getId() > 0);
		
		try(var conn = getConnection();
				var stmt = conn.prepareStatement(UPDATE)) {
			
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setTimestamp(4, Timestamp.valueOf(user.getCreation()));
			stmt.setInt(5, user.getId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
		}
		
	}
	
	public void delete(int id) {
		
		try(var conn = getConnection();
				var stmt = conn.prepareStatement(DELETE)) {
			
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User findById(int id) {
		try(var conn = getConnection();
				var stmt = conn.prepareStatement(SELECT.concat(" where id = ?"))) {
			
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
//				var userId = rs.getInt("id");
//				var username = rs.getString("username");
//				var email = rs.getString("email");
//				var password = rs.getString("password");
//				var creation = rs.getTimestamp("creation");
				
				return getUser(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public long countAllUser() {
		
		return findAll().size();
		
//		try(var conn = getConnection();
//				var stmt = conn.prepareStatement(COUNT)) {
//			
//			ResultSet rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				var count = rs.getLong("result");
//				
//				return count;
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return 0;
		
	}
	
	public int save(User user) {
				
		try(var conn = getConnection();
				var stmt = conn.prepareStatement(INSERT)) {
			
			stmt.setString(1, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(2, user.getEmail());
			
			if(null != user.getCreation())
				stmt.setTimestamp(4, Timestamp.valueOf(user.getCreation()));
			else
				stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	private User getUser(ResultSet rs) throws SQLException {
		return new User(rs.getInt("id"), 
				rs.getString("username"), 
				rs.getString("email"), 
				rs.getString("password"), 
				rs.getTimestamp("creation").toLocalDateTime());
	}
	
	public void truncate(String... tables) {
		
		try(var conn = getConnection();
				var stmt = conn.createStatement()) {
			
			stmt.execute("set foreign_key_checks = 0");
			
			for(String table : tables) {
				stmt.execute("truncate table %s".formatted(table));
			}
			
			stmt.execute("set foreign_key_checks = 1");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}