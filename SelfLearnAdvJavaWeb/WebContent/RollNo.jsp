<HTML>
 <BODY>
    <H1>Online Results</H1>

<%
String err=(String)request.getAttribute("error");
if(err !=null){
%>

<FONT color=red> <%=err%> </FONT>
<%
}
%>

    <FORM METHOD=GET ACTION="RollNoCtl.jsp">
	  Enter Roll No 
	  <INPUT TYPE="text" NAME="rollNo">
      <INPUT TYPE="submit" Value="Go">    								
    </FORM>
	   
  <%@include file="Footer.jsp" %>

 </BODY>
</HTML>
