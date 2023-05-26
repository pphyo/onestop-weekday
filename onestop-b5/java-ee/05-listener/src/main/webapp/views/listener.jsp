<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listener</title>
</head>
<body>

	<h3>Application Scope Listener</h3>
	
	<a href="/listener">Go to</a> <br />
		
	<c:if test="${not empty message}">
		<c:out value="${message}"></c:out>
	</c:if>
	<br />
	<c:if test="${not empty data}">
		<c:out value="${data}"></c:out>
	</c:if>
	
	<form action="/listener" method="post">
		<button type="submit">Remove Attr</button>
	</form>
	
	<hr />

</body>
</html>