

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDarkBeer
 */
public class ShowDarkBeer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDarkBeer() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<body>"
				+ "<font color=black>"
				+ "<h1 align=center>You seleted the Dark beer</h1>"
				+ "<br>"
				+ "</font>"
				+ "</body>"
				+ "</html>");

	}
	*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<body>"
				+ "<font color=black>"
				+ "<h1 align=center>You seleted the dark beer</h1>"
				+ "<br>"
				+ "</font>"
				+ "</body>"
				+ "</html>");
	}

}
