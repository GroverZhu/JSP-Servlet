package ex3;

import java.io.IOException;
import java.io.PrintWriter;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer itemCount = (Integer)session.getAttribute("itemCount");
		
		if (itemCount == null) {
			itemCount = new Integer(0);
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String[] itemsSelected;
		itemsSelected = request.getParameterValues("item");
		
		if (itemsSelected != null) {
			for (String itemName : itemsSelected) {
				System.out.println(itemName);
				itemCount = new Integer(itemCount.intValue() + 1);
				
				session.setAttribute("item" + itemCount, itemName);
				
				session.setAttribute("itemCount", itemCount);
			}
		}
		
		out.println("<html>");
		out.println("<title>");
		out.println("item list");
		out.println("</title>");
		out.println("<body><h4>Session List:</h4><hr><br><br>");
		for(int i=1;i<=itemCount.intValue();i++){
			out.println((String)session.getAttribute("item"+i)+"<hr>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();	
	}

}
