

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CodeReturn
 */
public class CodeReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeReturn() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 用户访问该网页时以输出流的方式向页面输出jar文件
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//定义返回的类型
		response.setContentType("application/jar");
		//通过上下文，获取bookCode.jar文件
		ServletContext ctx = getServletContext();
		InputStream is = ctx.getResourceAsStream("bookCode.jar");
		//以字节流的形式输出
		int read = 0;
		byte[] bytes = new byte[1024];
		OutputStream os = response.getOutputStream();
		while ((read = is.read(bytes)) != -1) {
			os.write(bytes, 0, read);
		}
		os.flush();
		os.close();
	}
}

