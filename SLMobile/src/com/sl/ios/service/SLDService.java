package com.sl.ios.service;

import com.sl.ios.entity.SanLianCeShi;

public interface SLDService extends SLDBaseService<SanLianCeShi, Integer>
{
	SanLianCeShi findById(String sid);

	int getCountOfUnExamineAndUnReaded(String uid);

	int getCountOfUnExamineAndReaded(String uid);
}
