package ex6;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class URLRequestFilter implements Filter {

	private FilterConfig config = null;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httprep = (HttpServletResponse) response;
//		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
//				(HttpServletResponse) response);
		String redirectPath = httpreq.getContextPath()
				+ config.getInitParameter("redirectPath");
		String disableFilter = config.getInitParameter("disableFilter");
		String includeStrings = config.getInitParameter("includeStrings");
		String[] includeList = includeStrings.split(";");
		if (disableFilter.toUpperCase().equals("Y")) {
			chain.doFilter(request, response);
			return;
		}
		if (disableFilter.toUpperCase().equals("N")) {
			boolean flag = false;
			for (int i = 0; i < includeList.length; i++) {
				if (httpreq.getRequestURI().indexOf(includeList[i]) != -1) {
					flag = true;
					break;
				}
			}
			if (flag) {
				chain.doFilter(request, response);
				return;
			} else {
				httprep.sendRedirect(redirectPath);
			}

		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		this.config = null;

	}

}
