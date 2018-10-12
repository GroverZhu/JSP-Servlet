<!-- 在DisplayItem.jsp中显示 -->
<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	%>

<%
	//声明Integer用来统计总共选择beer color的次数
	Integer colorCount = (Integer) session.getAttribute("colorCount");
	//判断session是否为新的，如果为新的，则创建一个
	if (colorCount == null) {
		colorCount = new Integer(0);
	}
	//设置返回输出类型
	response.setContentType("text/html");
	//将request中的传来所选的beer color 写入session中
	String colorSelected;
	colorSelected = request.getParameter("color");

	if (colorSelected != null) {
		colorCount = new Integer(colorCount.intValue() + 1);
		session.setAttribute("color" + colorCount, colorSelected);
		session.setAttribute("colorCount", colorCount);
	}
%>

<html>
<title>color list</title>
<body>
	<h4>Session List:</h4>
	<hr>
	<br>
	<br>
	<%
		//输出选择过的beer color的所有值
		for (int i = 1; i <= colorCount.intValue(); i++) {
			out.println((String) session.getAttribute("color" + i) + "<hr>");
		}
	%>
</body>
</html>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="ex3.*"%>
<%
    //声明一个ArrayList对象，用来存储Beer对象
    ArrayList<Beer> beerList = (ArrayList<Beer>)session.getAttribute("BeerList"); 
    //判断session是否为新的，如果为新的，则创建一个
    if (beerList == null) {
        beerList = new ArrayList<Beer>();
    }
    //设置返回输出类型
    response.setContentType("text/html");
    //将request中的传来所选的beer color 写入Beer的color中
    String colorSelected;
    colorSelected = (String)request.getParameter("color");
    System.out.println(colorSelected + " parameter Value");
    //redirect中会出现空值
    if (colorSelected != null) {
        Beer beer = new Beer();
        beer.setColor(colorSelected);
        System.out.println(beer.toString() + " java bean");
        beerList.add(beer);
        session.setAttribute("BeerList", beerList);
    }
%>

<html>
<title>color list</title>
<body>
	<h4>Session List:</h4>
	<hr>
	<br>
	<br>
	<%
        //输出选择过的beer color的所有值
        ArrayList<Beer> beers = (ArrayList<Beer>)session.getAttribute("BeerList");
        if (beers != null) {
            for (Beer b : beers) {
            	   out.println(b.getColor() + "<br>");
            	   }
            }

    %>
</body>
</html>
