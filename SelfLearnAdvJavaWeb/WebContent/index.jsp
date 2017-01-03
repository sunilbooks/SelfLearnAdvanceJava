<html>
<%
	String ctxUrl = "http://localhost:8080/SelfLearnAdvJavaWeb/";
%>

<body>
	<table border="1">
		<tr>
			<th colspan="2"><H1>API Version</H1></th>
		</tr>
		<tr>
			<td>API Version</td>
			<td><a href="Version.jsp"><%=ctxUrl%>Version.jsp</a></td>
		</tr>


		<tr>
			<th colspan="2"><H1>Getting Started</H1></th>
		</tr>
		<tr>
			<td>Hello JSP</td>
			<td><a href="HelloFor.jsp">http://localhost:8080/SelfLearnAdvJavaWeb/HelloFor.jsp</a></td>
		</tr>

		<tr>
			<td>Hello Servlet</td>
			<td><a href="Hello">http://localhost:8080/SelfLearnAdvJavaWeb/Hello</a></td>
		</tr>
		<tr>
			<th colspan="2"><H1>Servlet</H1></th>
		</tr>
		<tr>
			<th colspan="2">Request object</th>
		</tr>
		<tr>
			<td>Print Header information</td>
			<td><a href="HeaderInfo">http://localhost:8080/SelfLearnAdvJavaWeb/HeaderInfo</a></td>
		</tr>

		<tr>
			<td>Print request information</td>
			<td><a href="RequestInfo">http://localhost:8080/SelfLearnAdvJavaWeb/RequestInfo</a></td>
		</tr>

		<tr>
			<th colspan="2">Response object</th>
		</tr>
		<tr>
			<td>Get Image as Response</td>
			<td><a href="GetImage">http://localhost:8080/SelfLearnAdvJavaWeb/GetImage</a></td>
		</tr>
		<tr>
			<td>Get Plain Text as response</td>
			<td><a href="GetPlainText">http://localhost:8080/SelfLearnAdvJavaWeb/GetPlainText</a></td>
		</tr>

		<tr>
			<th colspan="2">Session Context</th>
		</tr>
		<tr>
			<td>Get Image as Response</td>
			<td><a href="GetImage">http://localhost:8080/SelfLearnAdvJavaWeb/GetImage</a></td>
		</tr>
		<tr>
			<td>Get Plain Text as response</td>
			<td><a href="GetPlainText">http://localhost:8080/SelfLearnAdvJavaWeb/GetPlainText</a></td>
		</tr>
		<tr>
			<th colspan="2"><H1>JSP</H1></th>
		</tr>
		<tr>
			<td>Hello JSP</td>
			<td><a href="HelloFor.jsp">http://localhost:8080/SelfLearnAdvJavaWeb/HelloFor.jsp</a></td>
		</tr>
		<tr>
			<td>JSP Scriptlet Tag</td>
			<td>Prints HelloJSP five times using while loop in Scriptlet tag<br>
				<a href="HelloWhile.jsp">http://localhost:8080/SelfLearnAdvJavaWeb/HelloWhile.jsp</a></td>
		</tr>

		<tr>
			<td>Include Directive <br>
			</td>
			<td>Includes Header.jsp and Footer.jsp into Marksheet.jsp <br>
				<a href="Marksheet.jsp">http://localhost:8080/SelfLearnAdvJavaWeb/Marksheet.jsp</a></td>
		</tr>

		<tr>
			<td>JSP Error Handling</td>
			<td>Exception is handled by ErrorHandler.jsp when incorrect age
				value is given<br> <a href="Age.jsp?age=16">http://localhost:8080/SelfLearnAdvJavaWeb/Age.jsp?age=16</a><br>
				<a href="Age.jsp?age=Sweet16">http://localhost:8080/SelfLearnAdvJavaWeb/Age.jsp?age=Sweet16</a>
			</td>
		</tr>

		<tr>
			<td>Forward Action Tag</td>
			<td>Enter RollNo and get marksheet, valid test roll number is
				'A1', <br> <a href="RollNo.jsp">RollNo.jsp</a>
			</td>
		</tr>

		<tr>
			<td><H1>Upload a File</H1></td>
			<td><a href="UploadFile.jsp"><%=ctxUrl%>UploadFile.jsp</a></td>
		</tr>

		<tr>
			<td colspan="2"><H1>Servlet's role based security</H1></td>
		</tr>

		<tr>
			<td>Configure Security constraines in web.xml</td>
			<td><a href="secured/SecuredJSP.jsp"><%=ctxUrl%>secured/SecuredJSP.jsp</a></td>
		</tr>
		<tr>
			<td>Configure Security constraines by @ServletSecurity</td>
			<td><a href="SecuredServlet"><%=ctxUrl%>SecuredServlet</a></td>
		</tr>

		<tr>
			<td colspan="2"><H1>MVC Architecture</H1></td>
		</tr>

		<tr>
			<td>User Management</td>
			<td>Add User <a href="user"><%=ctxUrl%>user</a> <BR>Update
				User <a href="user?id=1"><%=ctxUrl%>user?id=1</a></td>
		</tr>
	</table>

</body>
</html>