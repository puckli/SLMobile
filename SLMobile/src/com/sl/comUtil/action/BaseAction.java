package com.sl.comUtil.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport
{
	protected static Logger log = Logger.getLogger(BaseAction.class);
	
	protected HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}

	protected HttpSession getSession()
	{
		return getRequest().getSession();
	}

	protected void textOut(String text)
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=UTF-8");
		try
		{
			resp.getWriter().print(text);
		}
		catch (IOException e)
		{
			log.error("BaseAction#textOut() error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	protected void jsontOut(String json)
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		try
		{
			resp.getWriter().print(json);
		}
		catch (IOException e)
		{
			log.error("BaseAction#jsontOut() error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	protected String toJson(Object obj)
	{
		try
		{
			Gson gson = new Gson();
			return gson.toJson(obj);
		}
		catch (Exception e)
		{
			log.error("BaseAction#toJson() error: " + e.getMessage());
			return null;
		}
	}
}
