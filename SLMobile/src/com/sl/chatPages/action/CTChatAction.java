package com.sl.chatPages.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.sl.chatPages.entity.CT1V1Msg;
import com.sl.chatPages.entity.CTFriendGroupMem;
import com.sl.chatPages.entity.CTUserinfo;
import com.sl.chatPages.service.CTChatService;
import com.sl.ios.entity.ULogin;
import com.sl.ios.service.CommonsService;

public class CTChatAction
{
	private static Logger log = Logger.getLogger(CTChatAction.class);
	private CTChatService chatService;
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

	public CTChatService getChatService()
	{
		return chatService;
	}

	public void setChatService(CTChatService chatService)
	{
		this.chatService = chatService;
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

	@SuppressWarnings("unchecked")
	public String login()
	{
		CTUserinfo user = (CTUserinfo) commonsService.getEntityBySerializableID(CTUserinfo.class, uid);
		if (user == null)
		{
			newCTUser(uid);
		}
		return "redMain";
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

	public String toMain()
	{
		CTUserinfo user = (CTUserinfo) commonsService.getEntityBySerializableID(CTUserinfo.class, uid);
		if (user == null)
		{
			return "nullUserError";
		}
		HttpSession session = getSession();
		// if (session.getAttribute("friends") == null)
		// {
		TreeMap<Integer, List<CTUserinfo>> friends = chatService.getFriendsMap(uid);
		session.setAttribute("friends", friends);
		// }
		getRequest().setAttribute("uid", uid);

		return "chatMainPage";
	}

	public String getSendNewMsgFriends()
	{
		// TODO
		List uinfo = chatService.getSendNewMsgFriends(uid);

		return null;
	}

	public String chat1v1()
	{
		HttpServletRequest req = getRequest();
		String touid = req.getParameter("touid");
		CTUserinfo uinfo = (CTUserinfo) commonsService.getEntityBySerializableID(CTUserinfo.class, touid);
		if(uinfo == null){
			boolean mark = newCTUser(uid);
			if(mark)
			{
				uinfo = (CTUserinfo) commonsService.getEntityBySerializableID(CTUserinfo.class, touid);
			}
		}
		req.setAttribute("touname", uinfo.getNickName());
		req.setAttribute("touid", touid);
		req.setAttribute("uid", uid);
		return "chat1v1";
	}

	public String sendMsg() throws IOException
	{
		HttpServletRequest req = getRequest();
		String touid = req.getParameter("touid");
		String msg = req.getParameter("msg");
		CT1V1Msg ms = new CT1V1Msg();
		ms.setSendUser(uid);
		ms.setReceiveUser(touid);
		ms.setTime(new Date());
		ms.setTxt(msg);
		ms.setState((short) 0);
		commonsService.saveEntity(ms);
		getTextOut().print("success");
		return null;
	}

	public String getNewMsg() throws IOException
	{
		HttpServletRequest req = getRequest();
		String sendUser = req.getParameter("sendUser");
		List<CT1V1Msg> list = chatService.getNewMsg(uid, sendUser);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		getJsonOut().print(json);
		System.out.println(json);
		if (list != null)
		{
			for (CT1V1Msg msg : list)
			{
				msg.setState((short) 1);
			}
			commonsService.saveOrUpdateCollection(list);
		}
		return null;
	}
	
	public String createGroupPage()
	{
		getRequest().setAttribute("uid", uid);
		return "createGroupPage";
	}
	
	public String createGroup()
	{
		HttpServletRequest req = getRequest();
		ULogin currentUser = (ULogin) commonsService.getEntityBySerializableID(ULogin.class, uid);
		
		
		
		
		return null;
	}
}
