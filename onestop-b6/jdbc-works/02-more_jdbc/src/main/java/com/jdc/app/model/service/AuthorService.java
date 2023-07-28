package com.jdc.app.model.service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.jdc.app.model.entity.Author;
import com.jdc.app.model.entity.Author.Gender;
import com.jdc.app.model.util.DbManager;
import com.jdc.app.model.util.StringUtil;

public class AuthorService {
	
	private static final String SELECT = "select * from authors where 1 = 1";
	
	public Author find(Gender gender, String email, String phone) {
		
		List<String> params = new LinkedList<String>();
		StringBuilder sb = new StringBuilder(SELECT);
		
		if(null != gender) {
			params.add(gender.name());
			sb.append(" and gender = ?");
		}
		
		if(!StringUtil.isEmpty(email)) {
			params.add(email);
			sb.append(" and email = ?");
		}
		
		if(!StringUtil.isEmpty(phone)) {
			params.add(phone);
			sb.append(" and phone = ?");
		}
		
		try(var conn = DbManager.getConnection();
				var stmt = conn.prepareStatement(sb.toString())) {
			
			for(int i = 0; i < params.size(); i++) {
				stmt.setString(i + 1, params.get(i));
			}
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var author = new Author();
				author.setId(rs.getInt("id"));
				author.setName(rs.getString("name"));
				author.setGender(Gender.valueOf(rs.getString("gender")));
				author.setEmail(rs.getString("email"));
				author.setPhone(rs.getString("phone"));
				return author;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
