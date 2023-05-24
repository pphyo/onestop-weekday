<%@page import="com.jdc.commu.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>

	<h3>User Table</h3>
	
	<!-- table>(thead>tr>td*3)+(tbody>tr>td*3) -->
	
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Email</td>
				<td>Address</td>
			</tr>
		</thead>
		<tbody>
		
			<% 
				@SuppressWarnings("unchecked")
				List<User> users = (List<User>)request.getAttribute("list");
			
				for(User user : users) {
			%>
			
			<tr>
				<td><%= user.getName() %></td>
				<td><%= user.getEmail() %></td>
				<td><%= user.getAddress() %></td>
			</tr>
			
			<% } %>
			
		</tbody>
	</table>

</body>
</html>