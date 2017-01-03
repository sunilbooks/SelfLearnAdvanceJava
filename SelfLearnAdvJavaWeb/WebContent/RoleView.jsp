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
	<form action="RoleCtl" >
		<table>
			<tr>
				<td>Code</td>
				<td><input name="code" type="text"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input name="name" type="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>
	<%@ include file="Footer.jsp" %>
</body>
</html>