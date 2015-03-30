package com.sl.ios.action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sl.comUtil.Setting;
import com.sl.comUtil.action.BaseAction;
import com.sl.ios.entity.Appendix;
import com.sl.ios.entity.PlaceAndElectronName;
import com.sl.ios.entity.PushToken;
import com.sl.ios.entity.SLDspRecord;
import com.sl.ios.entity.SanLianCeShi;
import com.sl.ios.entity.Sldexamine;
import com.sl.ios.entity.SldyiJian;
import com.sl.ios.entity.ULogin;
import com.sl.ios.service.CommonsService;
import com.sl.ios.service.IOSService;
import com.sl.ios.service.SLDService;
import com.sl.ios.service.SLDUserService;
import com.sl.ios.util.ImageCompress;
import com.sl.ios.util.PushManager;
@SuppressWarnings("rawtypes")
public class IosAction extends BaseAction
{
	private static Logger logger = Logger.getLogger(IosAction.class);
	private static final long serialVersionUID = -1837627300119049027L;
	private CommonsService commonsService;
	private IOSService iosService;
	private SLDUserService sldUserService;
	private SLDService sldService;
	
	private String uid;

	public void setUid(String uid) {
		this.uid = uid;
	}
	

	public String getUid()
	{
		return uid;
	}


	@Autowired
	public void setIosService(IOSService iosService)
	{
		this.iosService = iosService;
	}
	
	@Autowired
	@Qualifier("SLDUserService")
	public void setSldUserService(SLDUserService sldUserService)
	{
		this.sldUserService = sldUserService;
	}

	public static void setLogger(Logger logger)
	{
		IosAction.logger = logger;
	}
	
	@Autowired
	@Qualifier("SLDService")
	public void setSldService(SLDService sldService)
	{
		this.sldService = sldService;
	}

	public void setCommonsService(CommonsService commonsService)
	{
		this.commonsService = commonsService;
	}
	
	public String mainPage() throws Exception
	{
		HttpServletRequest req = getRequest();
		ULogin currentUser = (ULogin)req.getSession().getAttribute("user");
		String uid = "";
		if(currentUser == null){
			uid = req.getParameter("username");
			if(uid != null && uid.length()>3)
			{
				try
				{
					currentUser = iosService.findUser(uid, null);
				}
				catch (Exception e)
				{
					logger.error("获取用户信息错误:" + uid);
					e.printStackTrace();
				}
				if(currentUser != null)
				{ 
					req.getSession().setAttribute("user", currentUser);
					req.getSession().setAttribute("uid", currentUser.getUid());
				}
				else{
					return "nullUserError";
				}
			}
			else{
				return "nullUserError";
			}
		}
		else{
			uid = currentUser.getUid();
		}
		String username = currentUser.getUname();
		if("赵军屹".equals(username)){
			req.setAttribute("uname", "总裁");
		}
		else{
			req.setAttribute("uname", username);
		}
		
		String dateStr = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
		int unExamine = iosService.getCountOfUnExamine(uid);
		int unExamineu = sldService.getCountOfUnExamineAndUnReaded(uid);
		int unExaminer = sldService.getCountOfUnExamineAndReaded(uid);
		int agree = iosService.getCountOfAgree(uid);
		int disagree = iosService.getCountOfDisagree(uid);
		
		req.setAttribute("date", dateStr);
		req.setAttribute("unExamine", unExamine);
		req.setAttribute("unExamineu", unExamineu);
		req.setAttribute("unExaminer", unExaminer);
		req.setAttribute("agree", agree);
		req.setAttribute("disagree", disagree);
		// 通过修改Setting.propertites中相关值动态改变主页
		if(Setting.zcAccount.indexOf(uid) > -1)
		{
			return Setting.ZC_INDEX_PAGE;
		}
		return Setting.DEFAULT_INDEX_PAGE.trim();
	}
	
	
	public String goSLDIndex()
	{
		HttpServletRequest req = getRequest();
		String uid = req.getParameter("uid");
		ULogin user = iosService.findByUid(uid);
		String username = user.getUname();
		if(Setting.zcAccount.equals(user.getUid())){
			req.setAttribute("uname", "总裁");
		}
		else{
			req.setAttribute("uname", username);
		}
		
		String dateStr = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
		int unExamine = iosService.getCountOfUnExamine(uid);
		int unExamineu = sldService.getCountOfUnExamineAndUnReaded(uid);
		int unExaminer = sldService.getCountOfUnExamineAndReaded(uid);
		int agree = iosService.getCountOfAgree(uid);
		int disagree = iosService.getCountOfDisagree(uid);
		
		req.setAttribute("date", dateStr);
		req.setAttribute("unExamine", unExamine);
		req.setAttribute("unExamineu", unExamineu);
		req.setAttribute("unExaminer", unExaminer);
		req.setAttribute("agree", agree);
		req.setAttribute("disagree", disagree);
		
		return "goSLDIndex";
	}
	
	// 获取未审核三联单
	public String getUnExamineSldList()
	{
		int max = Setting.SLD_PAGE_ROW;
		HttpServletRequest request = getRequest();
		String uid = request.getParameter("uid");
		int pageCount = (iosService.getCountOfUnExamine(uid) + max - 1) / max;
		String pageStr = request.getParameter("pageNow");
		int pageNow = (pageStr != null && pageStr.length()>0) ? Integer.parseInt(pageStr) : 1;
		
		List<SanLianCeShi> list = iosService.getUnExamineSldList(uid, (pageNow -1)* max, max);
		request.setAttribute("ueList", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("uid", uid);
		return "unExamineSldList";
	}
	
	@SuppressWarnings("unchecked")
	public String viewAndExamine()
	{
		HttpServletRequest request = getRequest();
		String uid = request.getParameter("uid");
		String sidStr = request.getParameter("sid");
		Integer sid = Integer.parseInt(sidStr);
		SanLianCeShi sld = (SanLianCeShi) commonsService.getEntityBySerializableID(SanLianCeShi.class, sid);
		findSignBySid(sid);
		findOpinionBySid(sid);
//		findImageOfSld(sld.getSlddls());
		request.setAttribute("sld", sld);
		request.setAttribute("uid", uid);
		
		ULogin currentUser = (ULogin) request.getSession().getAttribute("user");
		Sldexamine examine = sld.getSldExamine();
		Sldexamine nextExamine = iosService.getExamine(examine.getYwlx().getYid(), examine.getLvl().intValue() + 1);
		if(currentUser == null)
		{
			currentUser = iosService.findUser(uid, null);
		}
		if(currentUser.getUlvl().intValue() == 1 && nextExamine != null)
		{
			request.setAttribute("jumpNext", "true");
		}
		else{
			request.setAttribute("jumpNext", "false");
		}
		
		return "viewAndExamine";
	}
	
	// 查找图片
	public void findImageOfSld(String slddls)
	{
		List<Appendix> list = iosService.findImageOfSld(slddls);
		getRequest().setAttribute("images", list);
	}
	
	// 查找三联单签名
	private void findSignBySid(Integer sid)
	{
		List<Sldexamine> list = iosService.findExaminedBySid(sid);
		PlaceAndElectronName sign = null;
		List<PlaceAndElectronName> signs = new ArrayList<>();
		for(Sldexamine s : list)
		{
			sign = new PlaceAndElectronName();
			sign.setAuditingPlace(s.getAuditingPlace());
			
			ULogin signUser = iosService.findSignUserBySidAndSeid(sid, s.getSeid()); 
			sign.setAuditingPeople(signUser.getImg());
			// 意见表中的审批人和审核表中的审核人进行对比，如果相同就不显示代，否则就显示代理人。
			if (signUser.getUid().equals(s.getExamineName().getUid()))
			{
				sign.setAuditingName(signUser.getUname());
			}
			else
			{
				sign.setAuditingName(s.getExamineName().getUname());
				if(signUser.getUname().equals(s.getProxyName().getUname()))
				{
					sign.setIsProxy("代");
				}
			}
			signs.add(sign);
		}
		sign = new PlaceAndElectronName();
		SanLianCeShi sld = (SanLianCeShi) commonsService.getEntityBySerializableID(SanLianCeShi.class, sid);
		sign.setAuditingPlace("本部经办");
		sign.setAuditingName(sld.getWritePeople().getUname());
		sign.setAuditingPeople(sld.getWritePeople().getImg());
		signs.add(sign);
		getRequest().setAttribute("electronName", signs);
	}
	
	// 查询三联单意见
	private void findOpinionBySid(Integer sid)
	{
		List<SldyiJian> list = iosService.findAllOpinionBySid(sid);
		getRequest().setAttribute("opinion", list);
	}
	
	// 审批三联单
	@SuppressWarnings("unchecked")
	public String examineSld()
	{
		HttpServletRequest request = getRequest();
		String sidStr = request.getParameter("sid");
		String opinion = request.getParameter("opinion").trim();
		String content = request.getParameter("content");
		String jumpNext = request.getParameter("jumpNext").trim();
		Integer sid = new Integer(sidStr);
		SanLianCeShi sld = (SanLianCeShi) commonsService.getEntityBySerializableID(SanLianCeShi.class, sid);
		ULogin currentUser = (ULogin) getSession().getAttribute("user");
		if(currentUser == null){
			currentUser = iosService.findUser(uid, null);
		}
		Sldexamine examine = sld.getSldExamine();
		
		if(!examine.getExamineName().getUid().equals(uid) && !examine.getProxyName().getUid().equals(uid))
		{
			return "redirectUnExamineSldList";
		}
		boolean mark = iosService.opinionIsExist(sid, examine.getSeid(), "1");
		if(mark){
			iosService.deleteOpinion(sid, examine.getSeid(), "1");
//			return "redirectUnExamineSldList";
		}
		
		Sldexamine nextExamine = iosService.getExamine(examine.getYwlx().getYid(), examine.getLvl().intValue() + 1);
		Sldexamine nextNextExamine = iosService.getExamine(examine.getYwlx().getYid(), examine.getLvl().intValue() + 2);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = format.format(new Date());
		
		SldyiJian yj = new SldyiJian();
		SLDspRecord record = new SLDspRecord();
		
		yj.setCertificateId(new Integer(sidStr));
		yj.setSldExamineid(examine.getSeid());
		yj.setYijianExamineName(currentUser);
		yj.setYijianModule("1");
		yj.setTs(dateString);
		yj.setVersion(0);
		yj.setLvl(examine.getLvl());
		
		record.setSldID(sid);
		record.setTs(dateString);
		record.setUid(uid);
		record.setDr(0);
		
		sld.setSptime(dateString);
		
		SldyiJian yj2 = new SldyiJian();
		boolean saveyj2 = false;
		if("agree".equals(opinion))
		{
			logger.info(uid+" 同意单据：" + sld.getSlddls());
			content = (content == null || "".equals(content)) ? "同意" : content; 
			yj.setYjcontent(content);
			yj.setYjname("审核");
			yj.setStatus(0);
			record.setType(1);
			// 去掉已读标识
			sld.setReaded(0);
			// 更新到下一级审核
			if(nextExamine != null && "false".equals(jumpNext))
			{
				String status = "级别:" + examine.getLvl().toString() + ",下一级审核:" + nextExamine.getExamineName().getUname()
						+ ",代理人:" + nextExamine.getProxyName().getUname();
				sld.setStatus(status);
				sld.setSldExamine(nextExamine);
				commonsService.updateEntity(sld);
				// 推送处理
				push(nextExamine);
			}
			else if(nextNextExamine != null && "true".equals(jumpNext)){
				String status = "级别:" + nextExamine.getLvl().toString() + ",下一级审核:" + nextNextExamine.getExamineName().getUname()
						+ ",代理人:" + nextNextExamine.getProxyName().getUname();
				sld.setStatus(status);
				sld.setSldExamine(nextNextExamine);
				commonsService.updateEntity(sld);
				
				yj2.setCertificateId(new Integer(sidStr));
				yj2.setSldExamineid(examine.getSeid());
				yj2.setYijianExamineName(currentUser);
				yj2.setYijianModule("1");
				yj2.setYjcontent("跳过");
				yj2.setTs(dateString);
				yj2.setVersion(0);
				yj2.setLvl(nextExamine.getLvl());
				yj2.setYjname("跳过");
				yj2.setStatus(0);
				saveyj2 = true;
				// 推送处理
				push(nextNextExamine);
			}
			else{
				sld.setStatus("已通过");
				sld.setSldExamine(null);
				sld.setCallBackStatus(0);
				sld.setIsFinish("已通过");
				commonsService.updateEntity(sld);
				try {
					iosService.generateNum(sld.getSid());
				} catch (Exception e) {
					logger.error("生成号错误:" + sld.getSlddls() + ",address:" + IosAction.class.getName()+".examineSld() " + new Date());
					e.printStackTrace();
				}
			}
		}
		else if ("disagree".equals(opinion)) {
			logger.info(uid+" 拒绝单据：" + sld.getSlddls());
			content = (content == null || "".equals(content)) ? "拒绝" : content; 
			yj.setYjcontent(content);
			yj.setYjname("拒绝");
			// 判断前面是否有总裁同意的意见
			boolean hasOpinion = iosService.isExistOpinionBySidAndUid(sld.getSid(), "SL0000");
			if(hasOpinion)
			{
				yj.setStatus(0);
				record.setType(1);
				// 更新到下一级审核
				if(nextExamine != null)
				{
					String status = "级别:" + examine.getLvl().toString() + ",下一级审核:" + nextExamine.getExamineName().getUname()
							+ ",代理人:" + nextExamine.getProxyName().getUname();
					sld.setStatus(status);
					sld.setSldExamine(nextExamine);
					commonsService.updateEntity(sld);
					// 推送处理
					push(nextExamine);
				}
				else{
					sld.setStatus("已通过");
					sld.setSldExamine(null);
					sld.setCallBackStatus(0);
					sld.setIsFinish("已通过");
					commonsService.updateEntity(sld);
					try {
						iosService.generateNum(sld.getSid());
					} catch (Exception e) {
						logger.error("生成号错误:" + sld.getSlddls() + ",address:" + IosAction.class.getName()+".examineSld() " + new Date());
						e.printStackTrace();
					}
				}
			}
			// 没有总裁意见，打回三联单
			else{
				yj.setStatus(2);
				record.setType(0);
				Sldexamine firstExamine = iosService.getExamine(examine.getYwlx().getYid(), 1);
				sld.setSldExamine(firstExamine);
				// 更新已有意见状态为1
				iosService.updateOpinionRefuse(sid);
				
				sld.setIsFinish("已打回");
				sld.setCallBackStatus(1);
				
				commonsService.updateEntity(sld);
			}
		}
		else {
			return "error";
		}
		
		commonsService.saveEntity(yj);
		if(saveyj2){
			commonsService.saveEntity(yj2);
		}
		commonsService.saveEntity(record);
		
		return "redirectUnExamineSldList";
	}
	
	// 标记单据为已读
	public String readed()
	{
		HttpServletRequest req = getRequest();
		String sid = req.getParameter("sid");
		SanLianCeShi sld = sldService.findById(sid);
		sld.setReaded(1);
		sldService.update(sld);
		return "redirectUnExamineSldList";
	}
	
	// 推送方法
	private void push(Sldexamine ex)
	{
		String examineUid = ex.getExamineName().getUid();
//		String proxyUid = ex.getProxyName().getUid();
		List<PushToken> examineTokenList = iosService.findIOSPushToken(examineUid);
		String str1 = "您有新单据需要审核！";
		int unExamine = iosService.getCountOfUnExamine(examineUid);
		for(PushToken token : examineTokenList)
		{
			PushManager push = new PushManager(null, token.getToken(), str1, unExamine);
			push.start();
		}
		// 代理
		/*if(!examineUid.equals(proxyUid)){
			List<PushToken> proxyTokenList = iosService.findIOSPushToken(proxyUid);
			String str2 = "您有新单据需要代理审核！";
			for(PushToken token : proxyTokenList)
			{
				PushManager push = new PushManager(token.getToken(), str2, 1);
				push.start();
			}
		}*/
	}
	
	public String getAgreeSldList()
	{
		int max = Setting.SLD_PAGE_ROW;
		HttpServletRequest request = getRequest();
		String pageNowStr = request.getParameter("pageNow");
		int page = (pageNowStr == null || "".equals(pageNowStr)) ? 1 : Integer.parseInt(pageNowStr);
		List<SanLianCeShi> list =  iosService.getSldListByOpinionType(uid, page, max, 1);
		int pageCount = (iosService.getCountOfAgree(uid) + max - 1) / max;
		request.setAttribute("agreeList", list);
		request.setAttribute("pageNow", page);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("uid", uid);
		return "agreeList";
	}
	
	public String getDisagreeSldList()
	{
		int max = Setting.SLD_PAGE_ROW;
		HttpServletRequest request = getRequest();
		String pageNowStr = request.getParameter("pageNow");
		int page = (pageNowStr == null || "".equals(pageNowStr)) ? 1 : Integer.parseInt(pageNowStr);
		List<SanLianCeShi> list =  iosService.getSldListByOpinionType(uid, page, max, 0);
		int pageCount = (iosService.getCountOfDisagree(uid) + max - 1) / max;
		request.setAttribute("disagreeList", list);
		request.setAttribute("pageNow", page);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("uid", uid);
		return "disagreeList";
	}
	
	@SuppressWarnings("unchecked")
	public String showSLD()
	{
		HttpServletRequest request = getRequest();
		String sidStr = request.getParameter("sid");
		String opinion = request.getParameter("opinion");
		String pageNow = request.getParameter("pageNow");
		Integer sid = new Integer(sidStr);
		SanLianCeShi sld = (SanLianCeShi) commonsService.getEntityBySerializableID(SanLianCeShi.class, sid);
		
		String pageList = "agree".equals(opinion) ? "getAgreeSldList" : "getDisagreeSldList";
		request.setAttribute("sld", sld);
		request.setAttribute("opinion", opinion);
		request.setAttribute("pageList", pageList);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("uid", uid);
		findOpinionBySid(sid);
		findSignBySid(sid);
		
		return "showSLD";
	}
	
	public String getImagePath() throws IOException
	{
		HttpServletRequest request = getRequest();
		String arg = request.getParameter("arg");
		Integer id = new Integer(arg);
		Appendix ap = (Appendix) commonsService.getEntityBySerializableID(Appendix.class, id);
		initOneImage(ap.getSldId(), ap.getAppendixName());
		String fileName = ap.getAppendixName();
		String sldid = ap.getSldId();
		String year = sldid.substring(2, 6);
		String month = sldid.substring(6,8);
		String path = "/upload/" + year + "/" + month + "/" + sldid;
		String imgPath = path + "/" + fileName;
		textOut(imgPath.substring(1));
		return null;
	}
	
	
	private List<String> initImageBySLDdls(String slddls)
	{
		List<Appendix> list = iosService.findImageOfSld(slddls);
		List<String> paths = new ArrayList<>();
		for(Appendix a : list)
		{
			String imgPath = initOneImage(a.getSldId(), a.getAppendixName());
			paths.add(imgPath.substring(1));
		}
		return paths;
	}
	
	private String initOneImage(String sldid,String fileName)
	{
		String year = sldid.substring(2, 6);
		String month = sldid.substring(6,8);
		String path = Setting.SLD_ATTACHMENT_ROOTPATH + year + "/" + month + "/" + sldid;
		String imgPath = path + "/" + fileName;
		String rootPath = getRequest().getSession().getServletContext().getRealPath("/");
		String realImgPath = rootPath+path;
		File file = new File(realImgPath);
		if(!file.exists())
		{
			file.mkdirs();
		}
		file = new File(rootPath + imgPath);
		if(!file.exists())
		{
			ImageCompress.compressImage(Setting.LARGE_IMAGE_PATH, realImgPath, fileName, sldid, true);
		}
		return imgPath;
	}
	
	public String loadImagePage()
	{
		HttpServletRequest request = getRequest();
		String sid = request.getParameter("sid");
		List<String> paths = initImageBySLDdls(sid);
		request.setAttribute("paths", paths);
		return "loadImagePage";
	}
	
}
