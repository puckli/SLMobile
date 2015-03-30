package com.sl.ios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.comUtil.Setting;
import com.sl.ios.dao.IosCommonsDAO;
import com.sl.ios.entity.Appendix;
import com.sl.ios.entity.PushToken;
import com.sl.ios.entity.SanLianCeShi;
import com.sl.ios.entity.Sldexamine;
import com.sl.ios.entity.SldyiJian;
import com.sl.ios.entity.ULogin;
import com.sl.ios.service.IOSService;

@Service("iosService")
@SuppressWarnings("rawtypes")
public class IOSServiceImpl implements IOSService {

	private IosCommonsDAO iosCommonsDAO;
	
	public IosCommonsDAO getIosCommonsDAO()
	{
		return iosCommonsDAO;
	}

	@Autowired
	public void setIosCommonsDAO(IosCommonsDAO iosCommonsDAO)
	{
		this.iosCommonsDAO = iosCommonsDAO;
	}

	@Override
	public ULogin findUser(String uid, String password) {
		return (ULogin) iosCommonsDAO.getEntityBySerializableID(ULogin.class, uid);
	}

	@Override
	public int getCountOfUnExamine(String uid) {
		String sql = "select count(1) from SanLianCeShi s left join Sldexamine e on s.sldExamine=e.seid where e.examineName='"
				+ uid + "' and s.isFinish<>'已通过' and s.isFinish<>'已打回' and s.zh is null and s.sid>"+Setting.minSID+" and s.dr=0";
		List lists = iosCommonsDAO.listByNative(sql);
		return (Integer) lists.get(0);
	}

	@Override
	public int getCountOfAgree(String uid) {
		String sql = "select count(distinct s.sldID) from SLDspRecord s where s.type=1 and s.uid='" + uid
				+ "' and s.dr=0 and s.sldID>"+Setting.minSID;
		List lists = iosCommonsDAO.listByNative(sql);
		return (Integer) lists.get(0);
	}

	@Override
	public int getCountOfDisagree(String uid) {
		String sql = "select count(distinct s.sldID) from SLDspRecord s where s.type=0 and s.uid='" + uid
				+ "' and s.dr=0 and s.sldID>"+Setting.minSID;
		List lists = iosCommonsDAO.listByNative(sql);
		return (Integer) lists.get(0);
	}

	@Override
	public List<SanLianCeShi> getUnExamineSldList(String uid) {
		String sql = "select s from SanLianCeShi s,Sldexamine e where s.sldExamine.seid=e.seid and e.examineName.uid='"
				+ uid + "' and s.zh is null and s.dr=0";
		List lists = iosCommonsDAO.findByHQL(sql);
		return lists;
	}

	@Override
	public List<SanLianCeShi> getUnExamineSldList(String uid, int first, int max) {
		String sql = "select s from SanLianCeShi s,Sldexamine e where s.sldExamine.seid=e.seid and e.examineName.uid='"
				+ uid + "' and s.zh is null and s.sid>"+Setting.minSID+" and s.isFinish<>'已通过' and s.isFinish<>'已打回' and s.dr=0 order by s.sptime desc,s.slddls desc";
		List lists = iosCommonsDAO.findByHQL(sql, first, max);
		return lists;
	}

	@Override
	public List<Sldexamine> findExaminedBySid(Integer sid) {
		String hql = "select s from Sldexamine s where s.seid in(select y.sldExamineid from SldyiJian y" +
				" where y.certificateId='"+ sid + "' and y.status=0 and y.yjname<>'跳过')";
		return iosCommonsDAO.findByHQL(hql);
	}

	@Override
	public ULogin findSignUserBySidAndSeid(Integer sid, Integer seid) {
		String hql = "select y from SldyiJian y where y.certificateId=? and y.sldExamineid=?";
		List<SldyiJian> list = iosCommonsDAO.listByHQL(hql, -1, -1, new Object[] { sid, seid });
		return list.get(0).getYijianExamineName();
	}

	@Override
	public boolean opinionIsExist(Integer sid, Integer seid, String module) {
		String hql = "select 1 from SldyiJian y where y.certificateId=? and y.sldExamineid=? and y.status=0 and y.yijianModule=?";
		List list = iosCommonsDAO.listByHQL(hql, -1, -1, new Object[] { sid, seid, module });
		return list.size() > 0;
	}

	@Override
	public Sldexamine getExamine(Integer id, int lvl) {
		String hql = "select s from Sldexamine s where s.ywlx.yid=? and s.lvl=? and dr='0'";
		List<Sldexamine> list = iosCommonsDAO.listByHQL(hql, -1, -1, new Object[] { id, lvl });
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<PushToken> findIOSPushToken(String examineUid) {
		String hql = "from PushToken p where p.uid=? and dr=0";
		List<PushToken> list = iosCommonsDAO.listByHQL(hql, -1, -1, new Object[] { examineUid });
		return list;
	}

	@Override
	public void generateNum(Integer sid) {
		String call = "{call generateNum(" + sid + ")}";
		iosCommonsDAO.callVoidPROC(call);

	}

	@Override
	public void updateOpinionRefuse(Integer sid) {
		String hql = "update SldyiJian y set y.status=1 where y.certificateId=? and y.status=0 and y.yijianModule='1'";
		iosCommonsDAO.executeHQL(hql, new Object[] { sid });
	}

	@Override
	public List<SanLianCeShi> getSldListByOpinionType(String uid, int page, int max, Integer type) {
		String hql = "from SanLianCeShi s where s.sid in(select r.sldID from SLDspRecord r where r.uid=? and r.type=? and r.sldID>"+Setting.minSID+" and r.dr=0)";
		List<SanLianCeShi> list = iosCommonsDAO.listByHQL(hql, page, max, new Object[] { uid, type });
		return list;
	}
	
	@Override
	public boolean isExistOpinionBySidAndUid(Integer sid, String uid)
	{
		String hql = "select 1 from SldyiJian y where y.certificateId=? and y.yijianExamineName.uid=? and y.status=0 and y.yijianModule=?";
		List list = iosCommonsDAO.listByHQL(hql, -1, -1, new Object[] { sid, uid, "1" });
		return list.size() > 0;
	}
	
	@Override
	public void deleteOpinion(Integer sid, Integer seid, String string)
	{
		String hql = "update SldyiJian y set y.status=1 where y.certificateId=? and y.sldExamineid=? and y.status=0 and y.yijianModule=?";
		iosCommonsDAO.executeHQL(hql, new Object[] { sid, seid, string });
	}
	
	@Override
	public List<SldyiJian> findAllOpinionBySid(Integer sid)
	{
		String hql = "from SldyiJian y where y.certificateId=" + sid + " and y.status=0 and y.yijianModule='1'";
		return iosCommonsDAO.findByHQL(hql);
	}
	
	@Override
	public List<Appendix> findImageOfSld(String slddls)
	{
		String hql = "from Appendix a where a.sldId like '" + slddls + "%' and a.dr=0" ;
		return iosCommonsDAO.findByHQL(hql);
	}
	
	@Override
	public ULogin findByUid(String uid)
	{
		String hql = "from ULogin where uid='" + uid + "' and dr=0";
		return (ULogin) iosCommonsDAO.findByHQL(hql).get(0);
	}
}
