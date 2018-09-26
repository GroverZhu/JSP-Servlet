

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowBrownBeer
 */
public class ShowBrownBeer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBrownBeer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<body>"
				+ "<font color=brown>"
				+ "<h1 align=center>You seleted the brown beer</h1>"
				+ "<br>"
				+ "</font>"
				+ "</body>"
				+ "</html>");

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<body>"
				+ "<font color=brown>"
				+ "<h1 align=center>You seleted the brown beer</h1>"
				+ "<br>"
				+ "</font>"
				+ "</html>");
	}
	*/
}
