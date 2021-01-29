<html>
<body>
	<h2>Welcome to Employee Association!</h2>
	<%
	RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
	rd.forward(request, response);
	%>
	<%-- 	<form action="<%=request.getContextPath()%>/register" method="post"> --%>
	<!-- 	<button type="submit" class="btn btn-primary" value='registerButton' -->
	<!-- 		name="registerButton">Register</button> -->
	<!-- 	<button type="submit" class="btn btn-primary" value='loginButton' -->
	<!-- 		name="loginButton">Login</button> -->
	<!-- 		</form> -->
</body>
</html>
