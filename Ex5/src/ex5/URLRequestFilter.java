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
 * 过滤未指定的访问类型
 */
public class URLRequestFilter implements Filter {

	private FilterConfig config = null;

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// 获取初始化参数
		String redirectPath = httpRequest.getContextPath() + config.getInitParameter("redirectPath");
		String disableFilter = config.getInitParameter("disableFilter");
		String includeStrings = config.getInitParameter("includeStrings");
		
		System.out.println("***");
		System.out.println(redirectPath);
		System.out.println(disableFilter);
		System.out.println(includeStrings);
		System.out.println("***");
		
		String[] includeList = includeStrings.split(";");
		
		if (disableFilter.toUpperCase().equals("Y")) {
			chain.doFilter(request, response);
			return;
		}
		if (disableFilter.toUpperCase().equals("N")) {
			boolean flag = false;
			for (int i = 0; i < includeList.length; i++) {
				if (httpRequest.getRequestURI().indexOf(includeList[i]) != -1) {
					flag = true;
					break;
				}
			}
			System.out.println(flag);
			if (flag) {
				chain.doFilter(request, response);
				return;
			} else {
				httpResponse.sendRedirect(redirectPath);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config = null;
	}

}
