<%@ page isErrorPage="true" import="java.io.*"%>

<font color="red">Error <%=exception.getMessage()%></font>

<%
	StringWriter sw = new StringWriter();
	PrintWriter pw = new PrintWriter(sw);
	exception.printStackTrace(pw);
	//print stack trace as HTML hidden comment
	out.print("<!--" + sw + "-->");
	sw.close();
	pw.close();
%>
