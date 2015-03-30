package com.sl.chatPages.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.sl.chatPages.entity.CT1V1Msg;
import com.sl.chatPages.entity.CTFriendGroup;
import com.sl.chatPages.entity.CTFriendGroupMem;
import com.sl.chatPages.entity.CTUserinfo;
import com.sl.chatPages.service.CTChatService;
import com.sl.comUtil.dao.CommonsDAO;

public class CTChatServiceImpl implements CTChatService
{
	private static Logger log = Logger.getLogger(CTChatServiceImpl.class);
	private CommonsDAO commonsDAO;

	public CommonsDAO getCommonsDAO()
	{
		return commonsDAO;
	}

	public void setCommonsDAO(CommonsDAO commonsDAO)
	{
		this.commonsDAO = commonsDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TreeMap<Integer,List<CTUserinfo>> getFriendsMap(String uid)
	{
		TreeMap<Integer,List<CTUserinfo>> map = new TreeMap<>();
		List<CTFriendGroup> groups = commonsDAO.findByHQL("from CTFriendGroup g where g.uid='"+uid+"' and dr=0 order by g.sequence");
		for(CTFriendGroup g : groups)
		{
			String hql = "select u from CTUserinfo u,CTFriendGroupMem m where u.uid=m.uid and m.groupID="+g.getId();
			List<CTUserinfo> gm = commonsDAO.findByHQL(hql);
			map.put(g.getSequence(), gm);
		}
		return map.size()>0 ? map : null;
	}
	
	@Override
	public List getSendNewMsgFriends(String uid)
	{
		String hql = "select u.uname,count(m.id) from com.sl.chatPages.entity.CT1V1Msg m left join com.sl.chatPages.entity.CTUserinfo u where u.uid=m.sendUser" +
				" and m.receiveUser='"+uid+"' and m.state=0 group by u.uid";
		
		String hql1 = "select distinct m from CT1V1Msg m where m.receiveUser='"+uid+"' and m.state=0";
		String hql2 = "select u.nickName from CTUserinfo u,CT1V1Msg m where u.uid=m.sendUser and m.receiveUser='" + uid + 
				"' and m.state=0";
		List<CT1V1Msg> list1 = commonsDAO.findByHQL(hql2);
		
		
//		List list = commonsDAO.findByHQL(hql);
		Map map = new HashMap();
		return list1;
	}
	
	@Override
	public List<CT1V1Msg> getNewMsg(String uid, String sendUser)
	{
		String hql = "from CT1V1Msg m where m.state=0 and m.receiveUser='" + uid +"'";
		if(null != sendUser)
		{
			hql += " and m.sendUser='" + sendUser + "' order by time";
		}
		else{
			hql += " order by time";
		}
		List<CT1V1Msg> list = commonsDAO.findByHQL(hql);
		return list.size()>0 ? list : null;
	}
}
















