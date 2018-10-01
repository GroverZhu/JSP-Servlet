<%@ page language="java" contentType="text/html"
	import="java.util.StringTokenizer" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body bgcolor="#FFFFFF">
	<h1 align="center">User Login</h1>
	<hr>
	<p>
		<b>User information:</b>
	</p>
	<%
    //获取已有的cookie，并将cookie中的name与password写入相应的输入框中
    String name = "";
    String password = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
    	for (Cookie cookie : cookies) {
    		if (cookie.getName().equals("namePwd")) {
    			String namePwd = cookie.getValue();
    			StringTokenizer namePwdToken = new StringTokenizer(namePwd, "_");
    			if (namePwdToken.countTokens() != 2) {
    				out.println("the name or password not Found!");
    			} else {
    			name = namePwdToken.nextToken();
    			password = namePwdToken.nextToken();

    			System.out.println("current user name: " + name);
    			System.out.println("current user password: " + password);
    			}
    		}
    	}
    }
    %>
	<!-- 输入用户名和密码 -->
	<form method="post" action="AutoLogin">
		<table width="500" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="100">User name:</td>
				<td width="431"><input type="text" name="name"
					value="<%=name%>"></td>
			</tr>
			<tr>
				<td width="100">Password</td>
				<td width="431"><input type="password" name="password"
					value="<%=password%>"></td>
			</tr>

		</table>
		<hr>
		<p>
			<input type="submit" name="btn_submit" value="Login"> <input
				type="reset" name="btn_reset" value="Reset">
		</p>
	</form>
	<p>&nbsp;</p>
</body>
</html>