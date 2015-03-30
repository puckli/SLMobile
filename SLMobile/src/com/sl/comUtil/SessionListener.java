package com.sl.comUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sl.ios.entity.ULogin;

/**
 * session监听，统计在线用户数量和用户登录的终端数量。
 * 实现：在用户登录方法slActioin.login()中，将用户信息放入session后调用本类addUserToOnlineList()方法
 * 
 * 
 * @author lwz
 * @time 2013-12-14 09:18:04
 */
public class SessionListener implements HttpSessionListener
{
	// sessionId, uid
//	public static Map<String,String> onlineSessionId = new HashMap<String,String>();
	// uid, 登录的客户端数量
	public static Map<String,Integer> onlineUserCount = new HashMap<String,Integer>();
	// uid, OnlineUser
	public static Map<String,OnlineUser> onlineUserMap = new TreeMap();
	@Override
	public void sessionCreated(HttpSessionEvent event)
	{
		HttpSession session = event.getSession();
		System.out.println("移动端已连接服务器 --会话号为： " + session.getId());
	}
	
	public static void doubleLoginOnOneBrowser(String oldUserID,HttpSession session)
	{
		if(onlineUserCount.containsKey(oldUserID))
		{
			int count = onlineUserCount.get(oldUserID);
			if(count == 1 || count < 1)
			{
				onlineUserCount.remove(oldUserID);
			}
			else if(count>1){
				onlineUserCount.put(oldUserID, --count);
			}
			
			int counts = onlineUserMap.get(oldUserID).getClientCount();
			if(counts == 1 || counts < 1)
			{
				onlineUserMap.remove(oldUserID);
			}
			else if(counts>1){
				onlineUserMap.get(oldUserID).countDecrease();
				onlineUserMap.get(oldUserID).getClientinfo().remove(session.getId());
			}
		}
	}
	
	// 用户登录处理
	public static void addUserToOnlineList(HttpSession session,OnlineUser ou)
	{
		String uid = ou.getUid();
//		onlineSessionId.put(session.getId(), uid);
		if(onlineUserCount.containsKey(uid))
		{
			int count = onlineUserCount.get(uid);
			onlineUserCount.put(uid, ++count);
		}
		else{
			onlineUserCount.put(uid, 1);
		}
		
		if(onlineUserMap.containsKey(uid))
		{
			onlineUserMap.get(uid).countAdd();
			onlineUserMap.get(uid).getClientinfo().putAll(ou.getClientinfo());
		}
		else{
			onlineUserMap.put(uid, ou);
			onlineUserMap.get(uid).setClientCount(1);
		}
		
		System.out.println(ou.getName() + ":" + uid +" 登陆， 当前 " + onlineUserCount.size() + " 位用户在线。");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event)
	{
		HttpSession session = event.getSession();
//		if(onlineSessionId.containsKey(session.getId()))
//		{
//			onlineSessionId.remove(session.getId());
//		}
		ULogin user = (ULogin)event.getSession().getAttribute("user");
		if(user != null) {
			String uid = user.getUid();
			if(onlineUserCount.containsKey(uid))
			{
				int count = onlineUserCount.get(uid);
				if(count == 1 || count < 1)
				{
					onlineUserCount.remove(uid);
				}
				else if(count>1){
					onlineUserCount.put(uid, --count);
				}
			}
			
			if(onlineUserMap.containsKey(uid))
			{
				int count = onlineUserMap.get(uid).getClientCount();
				if(count == 1 || count < 1)
				{
					onlineUserMap.remove(uid);
				}
				else if(count>1){
					onlineUserMap.get(uid).countDecrease();
					onlineUserMap.get(uid).getClientinfo().remove(session.getId());
				}
			}
			System.out.println(user.getUname() + ":" + user.getUid() +" 退出， 当前 " + onlineUserCount.size() + " 位用户在线。");
		}
	}

}
