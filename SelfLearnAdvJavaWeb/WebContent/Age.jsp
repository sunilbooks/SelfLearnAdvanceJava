<%@ page errorPage="ErrorHandler.jsp"%>
<html>
<body>
	<%
		int age;
		age = Integer.parseInt(request.getParameter("age"));
	%>
	<p>
		Your age is:
		<%=age%>
		years.
	</p>
</body>
</html>
