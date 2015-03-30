package com.sl.comUtil;

import java.util.HashMap;
import java.util.Map;

public class OnlineUser
{
	private String uid;
	private String name;
	private int clientCount = 0;
	// sessionid  [ip,browser,os]
	private Map<String,String[]> clientinfo = new HashMap();
	
	public String getUid()
	{
		return uid;
	}
	public void setUid(String uid)
	{
		this.uid = uid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getClientCount()
	{
		return clientCount;
	}
	public void setClientCount(int clientCount)
	{
		this.clientCount = clientCount;
	}
	
	public Map<String, String[]> getClientinfo()
	{
		return clientinfo;
	}
	public void setClientinfo(Map<String, String[]> clientinfo)
	{
		this.clientinfo = clientinfo;
	}
	
	public void countAdd()
	{
		this.clientCount++;
	}
	public void countDecrease()
	{
		this.clientCount--;
	}
}
