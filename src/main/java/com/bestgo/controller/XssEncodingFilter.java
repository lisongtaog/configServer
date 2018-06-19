package com.bestgo.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.bestgo.controller.XssHttpServletRequestWrapper;

public class XssEncodingFilter implements Filter{
	private boolean enable = Boolean.TRUE;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		if(enable) {
			XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(
					(HttpServletRequest) request);
			filterChain.doFilter(xssRequest, response);
			return;
		} 
			
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String enableStr = filterConfig.getInitParameter("enable");
		if(StringUtils.isNotBlank(enableStr)) {
			try {
				enable = Boolean.valueOf(enableStr);
			} catch (Throwable t) {
				enable = Boolean.TRUE;
			}
		}
	}

} 
