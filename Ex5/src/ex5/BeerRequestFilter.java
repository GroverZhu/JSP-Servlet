package ex5;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * -*- encoding:UTF-8 -*-
 * 
 * @author GroverZhu 根据选择的beer color在控制台上打印出相应的消息
 */
public class BeerRequestFilter implements Filter {
	// 定义选择light beer的次数
	private static int nCount = 0;
	FilterConfig config = null;

	/**
	 * @see Filter #init(FilterConfig) 初始化Filter
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	/**
	 * @see Filter #doFilter(ServletRequest, ServletResponse, FilterChain)
	 * 实现Filter的主体功能
	 * 统计选择light beer的次数，根据选择不同的beer在控制台上打印出不同的消息
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// 获取beer的color值
		String contents = httpRequest.getParameter("color");
		// 根据不同的颜色在控制台打印出不同的语句
		if (contents != null) {
			if (contents.equals("light")) {
				++nCount;
				System.out.println("BeerRequestFilter: There are " + nCount + " person(s) select the light beer!");
				// 进入下一个过滤
				filterChain.doFilter(request, response);
			} else {
				System.out.println("BeerRequestFilter: Nobody selects the light Beer!");
				// 进入下一个过滤
				filterChain.doFilter(request, response);
			}
		} else {
			// 进入下一个过滤
			filterChain.doFilter(request, response);
			System.out.println("BeerRequestFilter: welcome to the beer world!");
		}
	}

	/**
	 * @see Filter #destroy()
	 * 销毁该过滤器
	 */
	public void destroy() {
		this.config = null;
	}
}
