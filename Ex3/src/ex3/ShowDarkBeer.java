package ex3;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String colorParam = "Dark"; PrintWriter out = response.getWriter();
		 * out.println("<html>" + "<body>" + "<h1 align=center>Beer Color</h1>"
		 * + "<hr><br>" + "You selected beer color is: " + colorParam + "<br>" +
		 * "Sorry, the dark beer's item display error!" + "</body>" +
		 * "</html>");
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String colorParam = "Dark";
		PrintWriter out = response.getWriter();
		out.println(
				"<html>" + "<body>" + "<h1 align=center>Beer Color</h1>" + "<hr><br>" + "You selected beer color is: "
						+ colorParam + "<br>" + "Sorry, the dark beer's item display error!" + "</body>" + "</html>");
	}

}
