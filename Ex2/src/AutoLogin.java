
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutoLogin
 */
public class AutoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutoLogin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      获取cookie，将name与password通过分隔符"_"存在同一个String中再将该String存在cookie中
	 *      通过StringTokenizer将name与password分别取出
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 将name与password存在同一字符串中，用“_”分隔，
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String namePwd = new String(name + "_" + password);

		System.out.println("input name and password: " + namePwd);
		System.out.println("input name: " + name);
		System.out.println("input password: " + password);

		// 用来判断是否已经cookie
		Boolean judge = true;

		// 获取cookie，判断是否存在已有的cookie，如果有的话就通过相关的属性更新值
		// 没有的话则生成新的cookie并返回
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("namePwd") && cookie.getValue().equals(namePwd)) {
					judge = false;
					break;
				}
			}
		}
		if (judge.equals(true)) {
			// 设置cookie的存活时间，若不设置则存在内存中，不写入硬盘
			// cookie的存活时间按second计算
			Cookie cookie = new Cookie("namePwd", namePwd);
			cookie.setMaxAge(24 * 60 * 60);
			response.addCookie(cookie);
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html>" + "<title>User List</title>" + "<body><h4>User List:</h4><hr><br><br>");

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("namePwd")) {
					String namePwds = cookie.getValue();
					StringTokenizer namePwdToken = new StringTokenizer(namePwds, "_");
					String nameToken = namePwdToken.nextToken();
					System.out.println("current cookie name: " + nameToken);
					out.print(nameToken);
				}
			}

		}
		out.println("</body>" + "</html>");
		out.close();
	}
}
