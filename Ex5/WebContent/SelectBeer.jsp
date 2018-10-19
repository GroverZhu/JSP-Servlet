<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="MyFirstTag" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select a color for beer!</title>
</head>
<body>
<%@ include file="Header_ins.jsp" %>
<h1 align="center">Beer Selection Page</h1>
<!-- Commit to a Servlet Page -->
<!-- form method="POST" action="SelectBeer.do" -->
<!-- Commit to a JSP Page -->
<form method="POST" action="BeerList.jsp">
This application has been visited  
<mytag:counter/> 
  times.<p> 
  There are kinds of beer for choose.<p>
 <mytag:colorSelect/>
  <center> 
    <input type="SUBMIT" value="Submit"> 
  </center>
</form>
</body>
</html>
