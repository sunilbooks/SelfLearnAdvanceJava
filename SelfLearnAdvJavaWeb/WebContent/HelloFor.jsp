<%@page import="java.util.Date,java.io.*"  contentType="text/html" buffer="8kb" isELIgnored="true"%>


<html>


<body>

	<%
		for (int i = 0; i < 5; i++) {
	%>
	<H1>
		<%=i + 1%> Hello JSP
	</H1>
	<%
		}
	%>

<%= new Date()%>


</body>
</html>