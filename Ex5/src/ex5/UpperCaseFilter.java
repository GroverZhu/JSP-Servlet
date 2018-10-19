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
 * Servlet Filter implementation class UpperCaseFilter
 */
public class UpperCaseFilter implements Filter {
	protected FilterConfig config;

    /**
     * Default constructor. 
     */
    public UpperCaseFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletResponse newResponse = response;
		if (request instanceof HttpServletRequest) {
			newResponse = new CharResponseWrapper((HttpServletResponse) response);
		}
		// 执行doFliter方法，此处的响应对象已经改变
		chain.doFilter(request, newResponse);
		// 以下执行响应过滤
		if (newResponse instanceof CharResponseWrapper) {
			String text = newResponse.toString();
			if (text != null) {
				text = text.toUpperCase();
				System.out.println("---\n" + text + "---\n");
				// 将输出的内容传给真正的输出流，返回客户端
				response.getWriter().write(text);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
