<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!-- 通过jsp:include调用已有的jsp -->
<!-- 对Header_act.jsp中的subTitle进行传值初始化 -->
<jsp:include page="Header_act.jsp">
    <jsp:param name="subTitle" value="Weclome to the Dark Beer World" />
</jsp:include>

<jsp:include page="DisplayItem.jsp" />