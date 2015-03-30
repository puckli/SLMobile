package com.sl.ios.service;

import java.util.List;

import com.sl.ios.entity.Appendix;
import com.sl.ios.entity.PushToken;
import com.sl.ios.entity.SanLianCeShi;
import com.sl.ios.entity.Sldexamine;
import com.sl.ios.entity.SldyiJian;
import com.sl.ios.entity.ULogin;

public interface IOSService
{
	ULogin findUser(String uid, String password);
	
	int getCountOfUnExamine(String uid);

	int getCountOfAgree(String uid);

	int getCountOfDisagree(String uid);

	List<SanLianCeShi> getUnExamineSldList(String uid);

	List<SanLianCeShi> getUnExamineSldList(String uid, int first, int max);

	List<Sldexamine> findExaminedBySid(Integer sid);

	ULogin findSignUserBySidAndSeid(Integer sid, Integer seid);

	/**
	 * 查询意见是否存在
	 * @param sid 三联单id
	 * @param seid 审核id
	 * @param i 意见所属模块，1代表三联单
	 * @return
	 */
	boolean opinionIsExist(Integer sid, Integer seid, String module);
	
	/**
	 * 获取审核
	 * @param id 业务类型(ywlx) id
	 * @param lvl 等级
	 * @return
	 */
	Sldexamine getExamine(Integer id, int lvl);

	/**
	 * 根据用户id查找推送token
	 * @param examineUid
	 * @return
	 */
	List<PushToken> findIOSPushToken(String examineUid);

	/**
	 * 调用存储过程生成三联单的三个号
	 * @param sid 
	 */
	void generateNum(Integer sid);

	void updateOpinionRefuse(Integer sid);

	/**
	 *  查询用户统一或不同意的单据
	 * @param uid  用户id
	 * @param page 当前第几页
	 * @param max 每页条数
	 * @param type 类型，1 同意，0不同意
	 * @return
	 */
	List<SanLianCeShi> getSldListByOpinionType(String uid, int page, int max, Integer type);
	
	/**
	 * 查询总裁意见是否存在
	 * @param sid
	 * @param uid
	 * @return
	 */
	boolean isExistOpinionBySidAndUid(Integer sid, String uid);
	
	/**
	 * 将对应意见status更新为1
	 * @param sid 三联id
	 * @param seid 审核id
	 * @param string 模块
	 */
	void deleteOpinion(Integer sid, Integer seid, String string);

	/**
	 * 根据三联单id查找所有意见
	 * @param sid
	 * @return
	 */
	List<SldyiJian> findAllOpinionBySid(Integer sid);

	/**
	 * 根据三联单id查找所有图片
	 * @param sid
	 * @return
	 */
	List<Appendix> findImageOfSld(String slddls);

	ULogin findByUid(String uid);
}
