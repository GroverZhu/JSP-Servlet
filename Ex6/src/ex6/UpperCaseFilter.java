package ex6;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * 将输出文本转化成大写的过滤器
 */
public class UpperCaseFilter implements Filter {
	protected FilterConfig config;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		ServletResponse newResponse = response;
		if (request instanceof HttpServletRequest) {
			newResponse = new CharResponseWrapper((HttpServletResponse) response);
		}
		// 执行doFilter方法，注意此处响应对象已经变化
		chain.doFilter(request, newResponse);
		// 以下执行响应过滤
		if (newResponse instanceof CharResponseWrapper) {

			String text = newResponse.toString();
			if (text != null) {
				text = text.toUpperCase();
				// 将输出的内容传给真正的输出流返回客户端
				response.getWriter().write(text);
			}
		}
	}
}
