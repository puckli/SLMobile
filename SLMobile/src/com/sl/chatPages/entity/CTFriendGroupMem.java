package com.sl.chatPages.entity;

public class CTFriendGroupMem
{
	private String id;
	private int groupID;
	private String uid;

	
	
	public CTFriendGroupMem()
	{
	}

	public CTFriendGroupMem(int groupID, String uid)
	{
		this.groupID = groupID;
		this.uid = uid;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getGroupID()
	{
		return groupID;
	}

	public void setGroupID(int groupID)
	{
		this.groupID = groupID;
	}

	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

}
