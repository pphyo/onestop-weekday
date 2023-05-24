<%@page import="com.jdc.scope.Counter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Scope</title>
</head>
<body>

	<h1>Scope Demo</h1>
	
	<table>
		<tr>
			<td>Request</td>
			<td>
				<%
					Object obj1 = request.getAttribute("counter");
					Counter req = obj1 != null ? (Counter) obj1 : new Counter();
				%>
				
				<%= req.getCount() %>
			</td>
		</tr>
		<tr>
			<td>Session</td>
			<td>
				<%
					Object obj2 = session.getAttribute("counter");
					Counter ses = obj2 != null ? (Counter) obj2 : new Counter();
				%>
				<%= ses.getCount() %>
			</td>
		</tr>
		<tr>
			<td>Application</td>
			<td>
				<%
					Object obj3 = application.getAttribute("counter");
					Counter app = obj3 != null ? (Counter) obj3 : new Counter();
				%>
				<%= app.getCount() %>
			</td>
		</tr>
		<tr>
			<td>
				<form action="/counter" method="post">
					<input type="submit" value="Invalidate" />
				</form>
			</td>
			<td><a href="/counter">Count Up</a></td>
		</tr>
	</table>

</body>
</html>