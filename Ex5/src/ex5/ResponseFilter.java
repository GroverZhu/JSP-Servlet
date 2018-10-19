package ex5;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * -*- encoding:UTF-8 -*-
 * @author GroverZhu
 * 实现响应过滤器，实现对动态Include的页面顶端加文字
 */
public class ResponseFilter implements Filter {

	private FilterConfig config = null;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		config = null;
	}

	/**
	 * 实现过滤器
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 获取response
		ServletResponse newResponse = response;
		if (request instanceof HttpServletRequest) {
			newResponse = new CharResponseWrapper((HttpServletResponse) response);
		}
		chain.doFilter(request, newResponse);
		
		// 将response头部添加指定的话
		if (newResponse instanceof CharResponseWrapper) {
			String text = newResponse.toString();
			if (text != null) {
				text = "<h1>This is an included section!</h1>" + text;
				System.out.println("+++\n" + text + "\n+++\n");
				response.getWriter().write(text);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
