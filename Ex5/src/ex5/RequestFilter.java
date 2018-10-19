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
 * -*- encoding:UTF-8 -*- 实现除了首页SelectBeer.jsp之外所有通过get方法访问页面请求的过滤
 * 
 * @author GroverZhu
 */
public class RequestFilter implements Filter {

	private FilterConfig config = null;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 用于判断是否满足SelectBeer.jsp发送的Get请求，
		boolean flag = true;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// 获取重定向路径(当前application的路径+init-param中的初始化的值)
		String redirectPath = httpRequest.getContextPath() + config.getInitParameter("redirectPath");
		System.out.println("-*-" + redirectPath + "-*-");
		// 判断request是否是get方法，且不是由SelectBeer.jsp发送的
		// 如果满足上述条件,则需要跳转
		if (httpRequest.getMethod().toUpperCase().equals("GET") && 
				httpRequest.getRequestURI().indexOf(redirectPath) == -1) {
				flag = false;
		}
		System.out.println("-*-" + flag + "-*-");
		// 根据flag的值是否满足跳转条件
		if (flag) {
			chain.doFilter(request, response);
			return;
		} else {
			httpResponse.sendRedirect(redirectPath);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
