<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Log In</title>
</head>
<body>

	<c:choose>
		<c:when test="${not empty user}">
			<p style="color:darkblue">You have already login.</p>
			
			<c:url value="/filter-view" var="filterLink"></c:url>
			<a href="${filterLink}" style="margin-right:4px">Home</a>
			<c:url value="/filter/auth/auth-view" var="authViewLink"></c:url>
			<a href="${authViewLink}">Go to Auth View</a>
		</c:when>

		<c:otherwise>
			<h3>Log In</h3>

			<form action="/filter/login" method="post">
				<table>
					<tbody>
						<c:if test="${not empty info}">
							<tr>
								<td colspan="2" style="color: red">${info}</td>
							</tr>
						</c:if>
						<tr>
							<td>Username:</td>
							<td><input type="text" name="username"
								placeholder="Enter username" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password"
								placeholder="Enter password" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Log In" /></td>
						</tr>
					</tbody>
				</table>
			</form>
		</c:otherwise>
	</c:choose>

</body>
</html>