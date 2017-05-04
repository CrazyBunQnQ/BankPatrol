package com.bank.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {
	private static final Logger LOGGER = LogManager.getLogger(EncodingFilter.class.getName());
	private String charEncoding = null;

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (!charEncoding.equals(request.getCharacterEncoding())) {
			request.setCharacterEncoding(charEncoding);
		}
//		response.setCharacterEncoding("text/html;charset=" + charEncoding);
		response.setCharacterEncoding(charEncoding);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) {
		charEncoding = fConfig.getInitParameter("encoding");
		if (charEncoding == null) {
			LOGGER.warn("EncodingFilter 中的编码设置为空！！！设置为默认编码：utf-8");
			charEncoding = "utf-8";
		}
	}

}
