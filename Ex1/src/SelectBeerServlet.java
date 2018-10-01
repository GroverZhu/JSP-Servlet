
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
	 * 根据所选color的值，显示出不同的页面
	 * 当color==brown, 通过redirect的方法向客户端返回页面
	 * (browser->destination)=>(browser->service),(service->browser),(browser->destination)
	 * redirect方法中客户端先向服务器发出请求，服务器向客户端返回301的重定向状态，之后客户端处理由服务器返回的新的路径
	 * 当color==dark, 通过dispatcher方法向客户端返回页面
	 * (browser->destination)=>(browser->service),(service->destination),(browser->service)
	 * dispatch方法中客户端向服务器发出请求，服务器去处理相应方法，最后通过服务器向客户端返回相应的数据
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
