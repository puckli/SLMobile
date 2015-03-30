package com.sl.chatPages.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.sl.chatPages.entity.CTFriendGroup;
import com.sl.chatPages.entity.CTFriendGroupMem;
import com.sl.chatPages.service.CTUserinfoService;
import com.sl.comUtil.dao.CommonsDAOImpl;
import com.sl.ios.entity.ULogin;

public class CTUserinfoServiceImpl implements CTUserinfoService
{
	private static Logger log = Logger.getLogger(CTUserinfoServiceImpl.class);
	private CommonsDAOImpl commonsDAO;

	public CommonsDAOImpl getCommonsDAO()
	{
		return commonsDAO;
	}

	public void setCommonsDAO(CommonsDAOImpl commonsDAO)
	{
		this.commonsDAO = commonsDAO;
	}

	@SuppressWarnings("unchecked")
	public List<ULogin> searchUser(String txt)
	{
		return commonsDAO.findByHQL("from ULogin u where u.uid like '%" + txt + "%' or u.uname like '%" + txt + "%'");
	}

	@Override
	public boolean addFriend(String uid, String fuid, Integer group)
	{
		List obj = commonsDAO.findByHQL("from CTFriendGroupMem m where m.uid='" + fuid + "' and m.groupID in" + "(select id from CTFriendGroup g where g.uid='" + uid + "')");
		if (obj == null || obj.size() == 0)
		{
			List<CTFriendGroup> mygrouplist = commonsDAO.findByHQL("from CTFriendGroup g where g.uid='" + uid +"' and g.sequence=0");
			CTFriendGroup mygroup = null;
			if(mygrouplist == null || mygrouplist.size() == 0)
			{
				mygroup = new CTFriendGroup(uid,0,"默认组",new Date(),(short)0);
				commonsDAO.saveEntity(mygroup);
			}
			else{
				mygroup = mygrouplist.get(0);
			}
			CTFriendGroupMem gm = new CTFriendGroupMem(mygroup.getId(),fuid);
			try
			{
				commonsDAO.saveEntity(gm);
				return true;
			}
			catch (Exception e)
			{
				log.error("添加联系人错误：" + uid +" + " + fuid);
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			return true;
		}
	}
}
