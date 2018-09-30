<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
String color = request.getParameter("color");
if (color.equals("amber")) {
%>
    <jsp:forward page="ShowAmberBeer.jsp"/>
<%  }
if (color.equals("brown")) {
	response.sendRedirect("ShowBrownBeer.jsp");
}
if (color.equals("dark")) {
//	RequestDispatcher view = request.getRequestDispatcher("ShowDarkBeer");
//	view.forward(request, response);
%>
    <jsp:forward page="ShowDarkBeer.jsp"/>
<% 
}
%>
<jsp:include page="Header_act.jsp">
    <jsp:param name="subTitle" value="Welcome to the Light Beer World!" />
</jsp:include>
<%@ include file="DisplayItem.jsp" %>