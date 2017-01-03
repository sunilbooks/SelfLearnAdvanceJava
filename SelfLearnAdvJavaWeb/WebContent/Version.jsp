<html>
<body>

	<B>Server Version </B>
	<%
		out.println(application.getServerInfo());
	%>
	<BR>
	<B>Servlet Version </B>
	<%
		out.println(request.getServletContext().getMajorVersion() + "."
				+ request.getServletContext().getMajorVersion());
	%>
	<BR>
	<B>JSP Version </B>
	<%
		out.print(JspFactory.getDefaultFactory().getEngineInfo()
				.getSpecificationVersion());
	%>
</body>
</html>