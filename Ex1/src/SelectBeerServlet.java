
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectBeerServlet
 */
public class SelectBeerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectBeerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String colorParam = request.getParameter("color");
		if (colorParam.equals("brown")) {
			response.sendRedirect("ShowBrownBeer");
		} else if (colorParam.equals("dark")) {
			RequestDispatcher view = request.getRequestDispatcher("ShowDarkBeer");
			view.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<html>" + "<body>" + "<h1 align=center>Beer Color</h1><br>" + "My selected beer color is:"
					+ colorParam + "</body>" + "</html>");
		}
	}

}
