package ex6;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class BeerRequestFilter implements Filter {

	private static int nCount = 0;
	FilterConfig config = null;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String contents = httpRequest.getParameter("color");
		if (contents != null) {
			if (contents.equals("light")) {
				++nCount;
				System.out.println("BeerRequestFilter:There are "
						+ nCount
						+ " person(s) select the light beer!");
				filterChain.doFilter(request, response);
			} else {
				System.out
						.println("BeerRequestFilter:Nobody selects the light Beer!");
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
			System.out.println("BeerRequestFilter:Welcome to the beer world!");
		}

	}

	public void destroy() {
		this.config = null;
	}

}
