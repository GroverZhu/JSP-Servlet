<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>item list</title>
</head>
<body>
    <h4>Session List: </h4><hr><br><br>
    <c:forEach var="item" items="${sessionScope.items}">
        ${item}<br>
    </c:forEach>
    <strong>
    itemCount:
    <c:out value="${sessionScope.itemCount }"/>
    </strong>
</body>
</html>