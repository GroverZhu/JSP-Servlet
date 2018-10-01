

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInitParams
 */
public class TestInitParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestInitParams() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 在web.xml配置初始化参数
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置输出格式
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("test init parameters<br>");
		//获取初始化参数的变量名(仅能访问，不可修改)
		java.util.Enumeration e = getServletConfig().getInitParameterNames();
		while (e.hasMoreElements()) {
			out.println("<br>param name = " + e.nextElement() + "<br>");
		}
		out.println("main email is " + getServletConfig().getInitParameter("mainEmail"));
		out.println("<br>");
		out.println("admin email is " + getServletConfig().getInitParameter("adminEmail"));
		//context param
		out.println("<br><br>" + getServletContext().getInitParameter("adminEmail"));
	}

}
