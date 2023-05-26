<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authority view</title>
</head>
<body>

	<h3>You have permission to access this page.</h3>
	
	<c:if test="${ not empty user }">
		<p>Your user name is ${user.get(0)}</p>
	</c:if>
	
	<a href="/filter-view" style="margin-right:4px">Home</a>
	<a href="/filter/logout">Log Out</a>

</body>
</html>