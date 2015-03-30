package com.sl.comUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import com.sl.ios.entity.Role;
import com.sl.ios.entity.Sldbm;
import com.sl.ios.entity.ULogin;

public class UtilMethod
{
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String dateTimeFormat()
	{
		return dateTimeFormat.format(new Date());
	}
	
	/**
	 * 格式：yyyy-MM-dd
	 * @return
	 */
	public static String dateFormat()
	{
		return dateFormat.format(new Date());
	}
	
	/**
	 * 获取用户固有权限(操作)，即部门和角色权限
	 * @param u Users 对象
	 * @return
	 */
	public static int calculatePVOperate(ULogin u)
	{
		if (u == null)
		{
			return 1;
		}
		int a = 1, b = 1;
		Sldbm dep = u.getDepartment();
		Set<Role> role = u.getRoles();
		if (dep != null && dep.getPvOperate() != null)
		{
			a = dep.getPvOperate();
		}
		if (role != null && role.size() > 0)
		{
			for(Iterator<Role> iter = role.iterator(); iter.hasNext();)
			{
				Role r = iter.next();
				b = b | r.getPvOperate();
			}
		}
		return a | b;
	}

	/**
	 * 计算用户的操作权限总权值 
	 * @param u 用户Users对象
	 * @return
	 */
	public static int calculatePVOperateTotal(ULogin u)
	{
		if (u == null)
		{
			return 1;
		}
		int a = calculatePVOperate(u);
		int b = 1;
		if (u.getPvOperate() != null)
		{
			b = u.getPvOperate();
		}
		return a | b;
	}
	
	
	/**
	 * 获取用户固有权限（菜单），即部门和角色权限
	 * @param u Users 对象
	 * @return
	 */
	public static int calculatePVMenu(ULogin u)
	{
		if (u == null)
		{
			return 1;
		}
		int a = 1, b = 1;
		Sldbm dep = u.getDepartment();
		Set<Role> role = u.getRoles();
		if (dep != null && dep.getPvMenu() != null)
		{
			a = dep.getPvMenu();
		}
		if (role != null && role.size() > 0)
		{
			for(Iterator<Role> iter = role.iterator(); iter.hasNext();)
			{
				Role r = iter.next();
				b = b | r.getPvMenu();
			}
		}
		return a | b;
	}

	/**
	 * 计算用户的菜单权限总权值 
	 * @param u 用户Users对象
	 * @return
	 */
	public static int calculatePVMenuTotal(ULogin u)
	{
		if (u == null)
		{
			return 1;
		}
		int a = calculatePVMenu(u);
		int b = 1;
		if (u.getPvMenu() != null)
		{
			b = u.getPvMenu();
		}
		return a | b;
	}
}
