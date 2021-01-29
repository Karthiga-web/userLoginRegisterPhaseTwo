<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
</head>

</head>
<body>
	<form action="<%=request.getContextPath()%>/register" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" id="uname" placeholder="First Name"
					name="firstName" required></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" id="uname" placeholder="last Name"
					name="lastName" required></td>
			</tr>
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
				<td>E-Mail:</td>
				<td><input type="text" id="email" placeholder="email"
					name="email" required></td>
			</tr>
			<tr>
				<td>Contact No:</td>
				<td><input type="text" id="contactNumber"
					placeholder="contactNumber" name="contactNumber" required></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><button type="submit" class="btn btn-primary"
						value='Register' name="submitButton">Submit</button></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><button type="submit" class="btn btn-primary"
						value='Member' name="memberButton">Already a Member?</button></td>
			</tr>
		</table>
		<%
		if (request.getAttribute("message") != null) {
		%>
		<h2><%=request.getAttribute("message")%></h2>
		<%
		}
		%>
	</form>

</body>
</html>