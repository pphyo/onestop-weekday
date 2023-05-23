package com.jdc.commu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private List<User> list;
	
	@Override
	public void init() throws ServletException {
		list = new ArrayList<>();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		
		User user = new User();
		user.setName(username);
		user.setEmail(email);
		user.setAddress(address);
		
		list.add(user);
		
		System.out.println(username);
		System.out.println(email);
		System.out.println(address);
		
		var writer = resp.getWriter();
		
		writer.append("""
				<!DOCTYPE html>
				<html>
				<head>
					<title>User List</title>
				</head>
				<body>
				<h2>User Table</h2>
				<table>
				<thead>
					<th>
						<td>Name</td>
						<td>Email</td>
						<td>Address</td>
					</th>
				</thead>
				<tbody>
				""");
		
		for(User u : list) {
			
			writer.append("""
					<tr>
						<td>%s</td>
						<td>%s</td>
						<td>%s</td>
					</tr>
					""".formatted(u.getName(), u.getEmail(), u.getAddress()));
			
		}
		
		writer.append("""
				</tbody>
				</table>
				</body>
				</html>
				""");
		
	}
	
}







