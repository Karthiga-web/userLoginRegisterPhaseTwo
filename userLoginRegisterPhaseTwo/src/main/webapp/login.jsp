<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/login" method="post">
		<%
		if (request.getAttribute("message") != null) {
		%>
		<h2><%=request.getAttribute("message")%></h2>
		<%
		}
		%>
		<table>
			<tr>
				<td>User Name:</td>
				<td><input type="text" id="username" placeholder="User Name"
					name="username" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" id="password" placeholder="Password"
					name="password" required></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><button type="submit" class="btn btn-primary">Login</button></td>
			</tr>
		</table>
	</form>
</body>
</html>