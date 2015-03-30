package com.sl.chatPages.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.sl.chatPages.entity.CTUserinfo;
import com.sl.chatPages.service.CTUserinfoService;
import com.sl.chatPages.serviceImpl.CTUserinfoServiceImpl;
import com.sl.ios.entity.ULogin;
import com.sl.ios.service.CommonsService;

public class CTUserAction
{
	private static Logger log = Logger.getLogger(CTUserAction.class);
	private CTUserinfoService userService;
	private CommonsService commonsService;
	private String uid;

	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public CommonsService getCommonsService()
	{
		return commonsService;
	}

	public void setCommonsService(CommonsService commonsService)
	{
		this.commonsService = commonsService;
	}

	public CTUserinfoService getUserService()
	{
		return userService;
	}

	public void setUserService(CTUserinfoService userService)
	{
		this.userService = userService;
	}

	private HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}

	private HttpSession getSession()
	{
		return getRequest().getSession();
	}

	private PrintWriter getTextOut() throws IOException
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf8");
		return resp.getWriter();
	}

	private PrintWriter getJsonOut() throws IOException
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=utf8");
		return resp.getWriter();
	}

	public String chatMainPage()
	{
		HttpServletRequest request = getRequest();

		return "chatMainPage";
	}

	public String addFriendPage()
	{
		getRequest().setAttribute("uid", uid);
		return "addFriendPage";
	}

	public String searchUser() throws IOException
	{
		HttpServletRequest req = getRequest();
		String txt = req.getParameter("txt");
		List<ULogin> list = userService.searchUser(txt);
		if (list != null && list.size()>0)
		{
			Gson gson = new Gson();
			String json = gson.toJson(list);
			getJsonOut().print(json);
		}
		return null;
	}
	
	public String addFriend() throws IOException
	{
		HttpServletRequest req = getRequest();
		String fuid = req.getParameter("fuid");
		boolean mark = false;
		ULogin ul = (ULogin) commonsService.getEntityBySerializableID(ULogin.class, fuid);
		if(ul != null)
		{
			Object obj = commonsService.getEntityBySerializableID(CTUserinfo.class , fuid);
			if(obj == null)
			{
				if(newCTUser(fuid))
				{
					if(userService.addFriend(uid, fuid, null))mark = true;
				}
			}
			else{
				if(userService.addFriend(uid, fuid, null))mark = true;
			}
		}
		if(mark){
			getTextOut().print("success");
		}
		else{
			getTextOut().print("fail");
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private boolean newCTUser(String uid)
	{
		short d = 0;
		ULogin ul = (ULogin) commonsService.getEntityBySerializableID(ULogin.class, uid);
		CTUserinfo uinfo = new CTUserinfo();
		uinfo.setUid(ul.getUid());
		uinfo.setUname(ul.getUname());
		uinfo.setNickName(ul.getUname());
		uinfo.setPhoto("default.png");
		uinfo.setDr(d);
		uinfo.setLastLogin(new Date());
		try
		{
			commonsService.saveEntity(uinfo);
		}
		catch (Exception e)
		{
			log.error("新增聊天用户错误！");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
