<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 使用c:if标签进行判断 -->
<!--  
<c:if test="${param.color eq 'amber'}">
	<jsp:forward page="ShowAmberBeer.jsp" />
</c:if>

<c:if test="${param.color eq 'brown'}">
	<jsp:forward page="ShowBrownBeer.jsp" />
</c:if>

<c:if test="${param.color eq 'dark'}">
	<jsp:forward page="ShowDarkBeer" />
</c:if>

<jsp:include page="Header_act.jsp">
	<jsp:param name="subTitle" value="Welcome to the Light Beer World!" />
</jsp:include>
<c:import url="DisplayItem.jsp" />
-->

<!-- 使用c:choose c:when c:otherwise进行判断 -->
<c:choose>
    <c:when test="${param.color eq 'amber' }">
        <jsp:forward page="ShowAmberBeer.jsp"/>
    </c:when>
    <c:when test="${param.color eq 'brown' }">
        <jsp:forward page="ShowBrownBeer.jsp"/>
    </c:when>
    <c:when test="${param.color eq 'dark' }">
        <jsp:forward page="ShowDarkBeer"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="Header_act.jsp">
            <jsp:param value="Weclome to the Light Beer World!" name="subTitle"/>
        </jsp:include>
        <c:import url="DisplayItem.jsp"/>
    </c:otherwise>
</c:choose>