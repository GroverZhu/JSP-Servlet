<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>item list</title>
</head>
<body>
<h4>Beer List:</h4><hr><br><br>
<table border="2">
<tr>
<td>beer id</td>
<td>beer name</td>
<td>beer manufacture</td>
<td>beer color</td>
<td>beer count</td>

</tr>
<c:forEach var = "beer" items="${beerlist}">
    <tr>
    <td>${beer.id}</td>
    <td>${beer.name}</td>
    <td>${beer.manufacture}</td>
    <td>${beer.color}</td>
    <td>${beer.count}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>