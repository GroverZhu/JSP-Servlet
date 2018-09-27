

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		Boolean judge = true;
		System.out.println(name);
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("name")) {
					cookies[i].setValue(name);
					judge = false;
				}
			}
		}
		if (judge.equals(true)) {
			Cookie cookie = new Cookie("name", name);
			
			cookie.setMaxAge(24*60*60);
			response.addCookie(cookie);
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html>"
				+ "<title>User List</title>"
				+ "<body><h4>User List:</h4><hr><br><br>");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("name")) {
					out.println(cookies[i].getValue());
				}
			}
		}
		out.println("</body>"
				+ "</html>");
		out.close();
	}

}
