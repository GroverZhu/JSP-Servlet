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
<jsp:setProperty name="beer" property="color" value="paramColor"/>

<!-- 通过EL表达式${param.color}获取color的值，相当于标准的getAttribute -->
<center><h2>print the color by EL. the color is ${param.color}</h2></center>

<%
//判断使用JavaBean声明的变量与设置变量属性值的正确性
if (paramColor.equals("amber")) {
//if (beer.getColor().equals("amber")) {
%>

<!-- 使用jsp的forward方法，相当于servlet中的dispatch -->
    <jsp:forward page="ShowAmberBeer.jsp"/>

<%  }
//使用paramColor无法传值过去
//if (paramColor.equals("brown")) {
if (beer.getColor().equals("brown")) {
	//使用redirect方法
	response.sendRedirect("ShowBrownBeer.jsp");
}
if (paramColor.equals("dark")) {
//if (beer.getColor().equals("dark")) {
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