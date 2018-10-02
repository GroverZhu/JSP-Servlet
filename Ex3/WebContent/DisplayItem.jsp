<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beer List</title>
</head>
<body>

<!-- Get the value of the variable "color"  -->
<%String colorParam = request.getParameter("color");%>

<h1 align="center">A Beer List of the color you selected</h1>
<hr>
<b>

<%out.println("You hava selected the "+colorParam+" Beer");%>
<br>
<!-- 使用EL输出color属性值 -->
<b>EL:You have selected the ${param.color} beer</b>
<br>
</b>
<p><b>Choose following information:</b></p>
<form method="post" action="ShoppingCart">
  <table width="500" border="0" cellspacing="0" cellpadding="0">
    <tr> 
      <td width="69"> 
        <input type="checkbox" name="item" value="The light beer of China">
      </td>
      <td width="431">Item1: The light beer of China</td>
    </tr>
    <tr> 
      <td width="69">
        <input type="checkbox" name="item" value="The amber beer of China">
      </td>
      <td width="431">Item2: The amber beer of China</td>
    </tr>
    <tr> 
      <td width="69">
        <input type="checkbox" name="item" value="The beer of American">
      </td>
      <td width="431">Item3: The beer of American</td>
    </tr>
  </table>
  <hr>
  <p>
  <center> 
    <input type="submit" name="btn_submit" value="Buy Now">
  </center>
  <jsp:include page="SelectedBeerColor.jsp" />
</form>
</body>
</html>