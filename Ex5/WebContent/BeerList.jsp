<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
	<jsp:param name="subTitle" value="Welcome to the Light Beer World!"/>
</jsp:include>
<c:import url="DisplayItem.jsp"/>
