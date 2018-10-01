import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCart extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获得seesion对象,如果session不存在，为本次会话创建此对象
		HttpSession session = request.getSession(true);
		
		//设定session的销毁时间为n分钟,此处的销毁时间以second计
		//当DD中有设置timeout，则此处的seesion的timeout时间为此处设置的值
		session.setMaxInactiveInterval(30);
		
		Integer itemCount = (Integer)session.getAttribute("itemCount");
		
		//如果session是新的
		if (itemCount == null) {
			itemCount = new Integer(0);
		}
		
		//设置输出格式
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String[] itemsSelected;
		itemsSelected = request.getParameterValues("item");
		
		if(itemsSelected != null) {
			for (String itemName : itemsSelected) {
				itemCount = new Integer(itemCount.intValue() + 1);
				System.out.println(itemName);
				//购买的条目
				session.setAttribute("item" + itemCount, itemName);
				//总条目
				session.setAttribute("itemCount", itemCount);
			}
		}
		
		out.println("<html>"
				+ "<title>item list </title>"
				+ "<body>"
				+ "<h4>Session List:</h4><br><br>");
		for (int i = 1; i <= itemCount.intValue(); i++) {
			out.println((String)session.getAttribute("item" + i) + "<hr>");
		}
		
		out.println("</body>"
				+ "</html>");
		out.close();

	} 
}
