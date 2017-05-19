package com.bank.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PermissionFilter implements Filter {
	private static final Logger LOGGER = LogManager.getLogger(PermissionFilter.class.getName());

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public PermissionFilter() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String servletPath = req.getServletPath();

		HttpSession session = req.getSession();
		String flag = (String) session.getAttribute("flag");

		if (servletPath != null && ("/Bank/login.jsp".equals(servletPath) 
				|| "/404.jsp".equals(servletPath) 
				|| "/500.jsp".equals(servletPath) 
				|| "/Logout".equals(servletPath) 
				|| (servletPath.length()> 3 && "/js".equals(servletPath.substring(0, 3))) 
				|| (servletPath.length()> 4 && "/css".equals(servletPath.substring(0, 4))) 
				|| (servletPath.length()> 6 && "/login".equals(servletPath.substring(0, 6))) 
				|| (servletPath.length()> 7 && "/images".equals(servletPath.substring(0, 7))) 
				)) {
			chain.doFilter(request, response);
		} else {
			if (flag != null && flag.equals("login_success")) {
				chain.doFilter(request, response);
			} else if (flag != null && flag.equals("login_error")) {
				LOGGER.info("用户登录失败");
				req.setAttribute("msg", "登录失败，请重新登陆！！！<br/>");
				req.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("msg", "您尚未登录！！！");
				LOGGER.info("用户未登录");
				req.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, resp);
			}
		}
	}

	public void destroy() {
	}
}
