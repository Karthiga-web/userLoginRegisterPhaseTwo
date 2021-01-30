<html>
<body>
	<h2>Welcome to Employee Association!</h2>
	<form action="<%=request.getContextPath()%>/index" method="post">
		<tr>
			<td>&nbsp;</td>
			<td><button type="submit" class="btn btn-primary"
					value='Register' name="registerButton">Register</button></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><button type="submit" class="btn btn-primary" value='Member'
					name="memberButton">Already a Member?</button></td>
		</tr>
	</form>
</body>
</html>
