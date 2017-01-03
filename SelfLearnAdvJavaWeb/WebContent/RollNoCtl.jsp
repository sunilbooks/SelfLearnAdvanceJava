<%@ page import="java.sql.*"%>

<%

String rn = request.getParameter("rollNo");

//Get data from database

if("A1".equals(rn)){
%>   
   <jsp:forward page="Marksheet.jsp" />
<%
}else{
	request.setAttribute("error","RollNo is not found"); 
%>
   <jsp:forward page="RollNo.jsp" />
<%
}
%>