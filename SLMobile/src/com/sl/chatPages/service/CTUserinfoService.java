package com.sl.chatPages.service;

import java.util.List;

import com.sl.ios.entity.ULogin;

public interface CTUserinfoService
{
	/**
	 * 根据用户名或者uid查找用户
	 * @param txt
	 * @return
	 */
	List<ULogin> searchUser(String txt);

	boolean addFriend(String uid, String fuid, Integer group);

}
