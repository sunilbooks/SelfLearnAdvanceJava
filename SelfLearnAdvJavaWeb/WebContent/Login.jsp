<html>
<body>
	<H1>Login</H1>

	<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
	%>
	<H3>
		<font color="red"><%=error%></font>
	</H3>
	<%
		}
	%>
	<form action="LoginCtl" method="POST">
		<table>
			<tr>
				<td>Login</td>
				<td><input name="userId" type="text"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Go"></td>
			</tr>
		</table>
	</form>
</body>
</html>