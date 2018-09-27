import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCart extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
//		设定session的销毁时间为3分钟
//		session.setMaxInactiveInterval(3*60);
		Integer itemCount = (Integer)session.getAttribute("itemCount");
		
		if (itemCount == null) {
			itemCount = new Integer(0);
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String[] itemsSelected;
		itemsSelected = request.getParameterValues("item");
		
		if(itemsSelected != null) {
			for (String itemName : itemsSelected) {
				System.out.println(itemName);
				itemCount = new Integer(itemCount.intValue() + 1);
				
				session.setAttribute("item" + itemCount, itemName);
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
