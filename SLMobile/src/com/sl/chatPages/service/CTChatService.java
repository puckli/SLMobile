package com.sl.chatPages.service;

import java.util.List;
import java.util.TreeMap;

import com.sl.chatPages.entity.CT1V1Msg;
import com.sl.chatPages.entity.CTFriendGroupMem;
import com.sl.chatPages.entity.CTUserinfo;

public interface CTChatService
{
	/**
	 * 查找用户的联系人列表
	 * @param uid
	 * @return
	 */
	TreeMap<Integer,List<CTUserinfo>> getFriendsMap(String uid);

	/**
	 * 获取给uid(当前用户)发送信息且uid(当前用户)未读的用户的列表
	 * @param uid
	 * @return
	 */
	List getSendNewMsgFriends(String uid);
	
	/**
	 * 获取sendUser发送给uid的新信息，sendUser为空则获取所有
	 * @param uid
	 * @param sendUser
	 * @return
	 */
	List<CT1V1Msg> getNewMsg(String uid, String sendUser);

}
