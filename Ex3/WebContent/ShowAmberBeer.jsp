<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 通过jsp:include来引用已有的jsp -->
<!-- 对Header_act.jsp中对subTitle进行初始化 -->
<jsp:include page="Header_act.jsp">
	<jsp:param name="subTitle" value="Weclome to the Amber Beer World" />
</jsp:include>

<jsp:include page="DisplayItem.jsp" />