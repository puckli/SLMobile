package com.sl.ios.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sl.comUtil.Setting;
import com.sl.ios.entity.SanLianCeShi;
import com.sl.ios.service.SLDService;

@Service("SLDService")
public class SLDServiceImpl extends SLDBaseServiceImpl<SanLianCeShi, Integer> implements SLDService
{
	@Override
	public SanLianCeShi findById(String sid)
	{
		String hql = "from SanLianCeShi where sid=" + sid;
		return SLDbaseDao.listAll(hql).get(0);
	}

	@Override
	public int getCountOfUnExamineAndReaded(String uid)
	{
		String sql = "select count(1) from SanLianCeShi s left join Sldexamine e on s.sldExamine=e.seid where e.examineName='" + uid
				+ "' and s.isFinish<>'已通过' and s.isFinish<>'已打回' and s.zh is null and s.sid>" + Setting.minSID + " and readed=1 and s.dr=0";
		List lists = SLDbaseDao.listByNative(sql);
		return (Integer) lists.get(0);
	}

	@Override
	public int getCountOfUnExamineAndUnReaded(String uid)
	{
		String sql = "select count(1) from SanLianCeShi s left join Sldexamine e on s.sldExamine=e.seid where e.examineName='" + uid
				+ "' and s.isFinish<>'已通过' and s.isFinish<>'已打回' and s.zh is null and s.sid>" + Setting.minSID + " and readed=0 and s.dr=0";
		List lists = SLDbaseDao.listByNative(sql);
		return (Integer) lists.get(0);
	}
}
