<%-- <%@ page import="java.util.*"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--显示所选的beer颜色对应的beer name --%>
<html>
<body>
	<h1 align="center">Beer Recommendations JSP</h1>
	<p>
		<c:forEach var="style" items="${styles}">
			<br>${style}
</c:forEach>
</body>
</html>