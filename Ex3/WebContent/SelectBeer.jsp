<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ex3.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!int kinds = 4;%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select a color for beer!</title>
</head>
<body>
	<%@ include file="Header_ins.jsp"%>
	<h1 align="center">Beer Selection Page</h1>
	<form method="POST" action="BeerList.jsp">
		You have selected the beer characteristics for
		<%=StasticInfo.getCount()%>.
		<p>
			There are
			<%
		out.println(kinds);
	%>
			kinds of beer for choose.
		<p>
			<select name="color" size="1">
				<option>light
				<option>amber
				<option>brown
				<option>dark

			</select>

			<ce nter> <input type="SUBMIT" value="Submit">
			</center>
	</form>
</body>
</html>