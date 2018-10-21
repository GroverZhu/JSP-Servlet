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
		boolean flag = false;
		// 用于判断是否符合资源路径，满足指定的jsp, .png文件
		boolean resFlag = false;

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// 获取重定向路径(当前application的路径+init-param中的初始化的值)
		String redirectPath = httpRequest.getContextPath() + config.getInitParameter("redirectPath");
		String includeStrings = config.getInitParameter("includeStrings");
		String disableFilter = config.getInitParameter("disableFilter");

		String[] includeList = includeStrings.split(";");

		System.out.println("-*-\n" + redirectPath + "\n" + includeStrings + "\n" + disableFilter + "\n-*-");
		// 判断初始化参数是否让该Filter生效
		if (disableFilter.toUpperCase().equals("Y")) {
			chain.doFilter(request, response);
		}
		if (disableFilter.toUpperCase().equals("N")) {
			// 判断是否符合资源要求
			for (int i = 0; i < includeList.length; i++) {
				if (httpRequest.getRequestURI().indexOf(includeList[i]) != -1) {
					resFlag = true;
					break;
				}
			}
			// 判断request是否是get方法
			if (!httpRequest.getMethod().toUpperCase().equals("GET")) {
				flag = true;
			}
			System.out.println("-*+\n" + resFlag + "\n" + flag + "+*-");
			// 根据flag 与 resFlag 的值是否满足跳转条件
			// 有条件可知SelectBeer.jsp中flag=false， resFlag=true
			if (flag || resFlag) {
				chain.doFilter(request, response);
				return;
			} else {
				httpResponse.sendRedirect(redirectPath);
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
