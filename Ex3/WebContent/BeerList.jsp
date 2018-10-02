<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="ex3.Beer" %>

<!-- 通过JavaBean声明变量 -->
<jsp:useBean id="beer" class="ex3.Beer" scope="session"/>

<!-- 获取color属性的值，根据不同的值显示不同的页面 -->
<%
String paramColor = request.getParameter("color");
%>

<!-- 通过JavaBean设置变量的值 -->
<jsp:setProperty name="beer" property="color" param="color"/>


<%
//判断使用JavaBean声明的变量与设置变量属性值的正确性
if (paramColor.equals("amber")) {
//if (beer.getColor().equals("amber")) {
%>

<!-- 使用jsp的forward方法，相当于servlet中的dispatch -->
    <jsp:forward page="ShowAmberBeer.jsp"/>

<%  }
//使用redirect方法，因为重定向，原先向服务器发送的值不再存在
//if (paramColor.equals("brown")) {
if (beer.getColor().equals("brown")) {
	//使用redirect方法
	response.sendRedirect("ShowBrownBeer.jsp");
}
//if (paramColor.equals("dark")) {
if (beer.getColor().equals("dark")) {
	//使用dispatch方法
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