package com.jdc.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QueryDao {
	
	static final String URL = "jdbc:mysql://localhost:3306/join_db";
	static final String USR = "root";
	static final String PWD = "pyaephyo";
	
	public List<TransferDto> find(String name, String level, int fees) {
		
		String query = """
				select c.name course_name, c.level, 
				c.duration course_duration, c.fees, 
				m.name module_name, m.duration module_duration, 
				m.description from course c join module m 
				on c.code = m.course_code where 1 = 1""";
		
		List<TransferDto> result = new ArrayList<>();
		
		List<Object> params = new LinkedList<>();
		StringBuilder sb = new StringBuilder(query);
		
		if(!isEmpty(name)) {
			sb.append(" and c.name like ?");
			params.add(name.concat("%"));
		}
		
		if(!isEmpty(level)) {
			sb.append(" and c.level = ?");
			params.add(level);
		}
		
		if(fees > 0) {
			sb.append(" and c.fees >= ?");
			params.add(fees);
		}
		
		try(var conn = getDbConnection();
				var stmt = conn.prepareStatement(sb.toString())) {
			
			for(int i = 0; i < params.size(); i++) {
				stmt.setObject(i + 1, params.get(i));
			}
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				result.add(new TransferDto(
						rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
						));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	public List<Course> findByName(String name) {
		
		String query = "select * from course where name like ?";
		
		List<Course> result = new ArrayList<>();
		
		try(var conn = getDbConnection();
				var stmt = conn.prepareStatement(query)) {
			
			stmt.setString(1, name.concat("%"));
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString("code");
				String courName = rs.getString("name");
				String level = rs.getString("level");
				int duration = rs.getInt("duration");
				int fees = rs.getInt("fees");
				var course = new Course(code, courName, level, duration, fees);
				result.add(course);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private boolean isEmpty(String data) {
		return null == data || data.isEmpty() || data.isBlank();
	}

	private Connection getDbConnection() throws SQLException {
		return DriverManager.getConnection(URL, USR, PWD);
	}
	
}