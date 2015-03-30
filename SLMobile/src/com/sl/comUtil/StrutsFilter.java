package com.sl.comUtil;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class StrutsFilter extends StrutsPrepareAndExecuteFilter
{
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
	{
		String reqURL = ((HttpServletRequest)req).getRequestURI();
//		System.out.println("reqURL:" + reqURL);
		if(reqURL != null && (reqURL.contains("socket") || reqURL.contains("Socket")))
		{
			chain.doFilter(req, res);
		}else{
			super.doFilter(req, res, chain);
		}
	}
	
}
