package com.sl.ios.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sl.comUtil.Setting;
import com.sl.comUtil.action.BaseAction;
import com.sl.ios.entity.ULogin;
import com.sl.ios.service.SLDUserService;
import com.sl.ios.util.PushPolling;

public class PushPollingAction extends BaseAction
{
	private SLDUserService sldUserService;
	
	@Autowired
	@Qualifier("SLDUserService")
	public void setSldUserService(SLDUserService sldUserService)
	{
		this.sldUserService = sldUserService;
	}
	
	private PrintWriter getTextOut() throws IOException
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf8");
		return resp.getWriter();
	}
	public String pushStart() throws IOException, SQLException
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String uid = request.getParameter("uid");
		String password = request.getParameter("password");
		String type = request.getParameter("arg");
		ULogin user = sldUserService.findByUidAndPassword(uid, password);
		
		if(user == null)
		{
			getTextOut().print("userWrong");
			return null;
		}
		int statue = 0;
		if("start".equals(type)){
			statue = PushPolling.startPushPolling();
		}
		else{
			statue = PushPolling.cancelPushPolling();
		}
		response.setContentType("text/html;charset=utf8");
		if(statue == 1)
		{
			response.getWriter().print("success");
		}
		if(statue == 0)
		{
			response.getWriter().print("isStarted");
		}
		return null;
	}
	
	public String reloadSetting() throws IOException
	{
		HttpServletRequest req = getRequest();
		String uid = req.getParameter("uid");
		String password = req.getParameter("password");
		ULogin user = sldUserService.findByUidAndPassword(uid, password);
		
		if(user == null)
		{
			getTextOut().print("userWrong");
			return null;
		}
		
		Setting.reloadSetting();
		getTextOut().print("success");
		System.out.println("reloadSetting success");
		return null;
	}
}
