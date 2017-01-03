<html>
<body>
	<H1>Secure Login</H1>

	<form action="j_security_check" method="POST">
		<table>
			<tr>
				<td>Login</td>
				<td><input name="j_username" type="text"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="j_password" type="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Sign In"></td>
			</tr>
		</table>
	</form>
</body>
</html>