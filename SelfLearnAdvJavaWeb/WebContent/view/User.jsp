<html>
<body>

	<H1>User</H1>

	<jsp:useBean id="error" class="java.lang.String" scope="request" />
	<jsp:useBean id="message" class="java.lang.String" scope="request" />
	<jsp:useBean id="user" class="com.sunilbooks.model.UserModel"
		scope="request" />

	<%!String getVal(String v) {
		v = (v == null) ? "" : v;
		return v;

	};%>

	<H3>
		<font color="green"><%=message%></font> <font color="red"><%=error%></font>
	</H3>

	<form action="user" method="POST">
		<input name="id" type="hidden"
			value="<%=user.getId() %>">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input name="firstName" type="text"
					value="<%=getVal(user.getFirstName())%>"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input name="lastName" type="text"
					value="<%=getVal(user.getLastName())%>"></td>
			</tr>
			<tr>
				<td>Login:</td>
				<td><input name="login" type="text"
					value="<%=getVal(user.getLogin())%>"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input name="password" type="password"
					value="<%=getVal(user.getPassword())%>"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input name="gender" type="text"
					value="<%=getVal(user.getGender())%>"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>

</body>
</html>