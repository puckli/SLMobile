package com.sl.ios.service.impl;

import org.springframework.stereotype.Service;

import com.sl.ios.entity.ULogin;
import com.sl.ios.service.SLDUserService;

@Service("SLDUserService")
public class SLDUserServiceImpl extends SLDBaseServiceImpl<ULogin, String> implements SLDUserService
{
	@Override
	public ULogin findByUid(String uid)
	{
		String hql = "from ULogin where dr=0 and uid='" + uid + "'";
		return super.getByHQL(hql);
	}
	
	@Override
	public ULogin findByUidAndPassword(String uid, String password)
	{
		String hql = "from ULogin where dr=0 and uid='" + uid + "' and upassword='" + password + "'";
		return super.getByHQL(hql);
	}
}
