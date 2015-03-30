package com.sl.ios.service;

import com.sl.ios.entity.ULogin;

public interface SLDUserService extends SLDBaseService<ULogin, String>
{

	ULogin findByUid(String uid);

	ULogin findByUidAndPassword(String uid, String password);
	
}
