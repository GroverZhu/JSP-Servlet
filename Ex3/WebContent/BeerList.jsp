<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!-- 获取color属性的值，根据不同的值显示不同的页面 -->
<%
String color = request.getParameter("color");
if (color.equals("amber")) {
%>

<!-- 使用jsp的forward方法，相当于servlet中的dispatch -->
    <jsp:forward page="ShowAmberBeer.jsp"/>

<%  }
if (color.equals("brown")) {
	//使用redirect方法
	response.sendRedirect("ShowBrownBeer.jsp");
}
if (color.equals("dark")) {
	//使用redirect方法
	//RequestDispatcher view = request.getRequestDispatcher("ShowDarkBeer");
	//view.forward(request, response);
%>

    <jsp:forward page="ShowDarkBeer.jsp"/>
    
<% 
}
%>

<jsp:include page="Header_act.jsp">
    <jsp:param name="subTitle" value="Welcome to the Light Beer World!" />
</jsp:include>

<%@ include file="DisplayItem.jsp" %>