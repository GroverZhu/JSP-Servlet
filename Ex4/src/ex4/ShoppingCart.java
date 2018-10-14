package ex4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCart
 */
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCart() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得Session对象
		// 如果Session不存在，为本次会话创建此对象
		HttpSession session = request.getSession(true);
		// 接收传来的参数
		ArrayList<String> items = (ArrayList<String>) session.getAttribute("items"); 
		Integer itemCount = (Integer) session.getAttribute("itemCount");
		// 如果session是新的则新建该对象
		if (itemCount == null){
			itemCount = new Integer(0);
			items = new ArrayList<String>();
		}
		String[] itemsSelected;
		String itemName;
		itemsSelected = request.getParameterValues("item");
		// 将所选择的beer按ArrayList方式存储，便于使用forEach.
		if (itemsSelected != null) {
			for (int i = 0; i < itemsSelected.length; i++) {
				itemName = itemsSelected[i];
				System.out.println(itemName);
				itemCount = new Integer(itemCount.intValue() + 1);
				items.add(itemName);
				// 总条目
				session.setAttribute("itemCount", itemCount);
			// 购买的条目
			session.setAttribute("items", items);	
			}
		}
		
		// session存储之后，跳转到ShowCart.jsp界面显示
		request.getRequestDispatcher("ShowCart.jsp").forward(request, response);

		/*PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<title>");
		out.println("item list");
		out.println("</title>");
		out.println("<body><h4>Session List:</h4><hr><br><br>");
		for (int i = 1; i <= itemCount.intValue(); i++) {
			out.println((String) session.getAttribute("item" + i) + "<hr>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();*/

	}
}
