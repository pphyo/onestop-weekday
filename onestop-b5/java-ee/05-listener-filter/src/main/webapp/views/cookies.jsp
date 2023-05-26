<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookies</title>
</head>
<body>

	<h3>Login Form</h3>
	<form action="/cookies" method="post">
		<table>
			<tbody>
				<tr>
					<td>Username: </td>
					<td>
						<input type="text" name="username" placeholder="Enter username" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Add to Cookie" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<% if(request.getAttribute("value") != null) { %>
		
		<p>Your value is <%= request.getAttribute("value") %> </p>
	
	<% } %>	

</body>
</html>