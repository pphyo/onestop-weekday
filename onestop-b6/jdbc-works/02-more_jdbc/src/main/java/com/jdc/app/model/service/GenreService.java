package com.jdc.app.model.service;

import static com.jdc.app.model.util.DbManager.getConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdc.app.model.entity.Genre;

public class GenreService {

	public void saveAll(List<String> genreList) {
		
		String sql = "INSERT INTO genres (name) values (?)";
		
		assert(genreList.size() > 0);
		
		try(var conn = getConnection();
				var stmt = conn.prepareStatement(sql)) {
			
			for(String name : genreList) {
				stmt.setString(1, name);
				stmt.addBatch();
			}
			
			stmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Genre> findAll() {
		String sql = "select * from genres";
		var result = new ArrayList<Genre>();
		
		try(var conn = getConnection();
				var stmt = conn.createStatement()) {
			
			var rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				var genre = new Genre();
				genre.setId(rs.getInt(1));
				genre.setName(rs.getString(2));
				
				result.add(genre);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
