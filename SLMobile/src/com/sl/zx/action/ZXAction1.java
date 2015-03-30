package com.sl.zx.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.sl.comUtil.RandomDataClass;
import com.sl.comUtil.Setting;
import com.sl.comUtil.ZTree;
import com.sl.ios.util.ImageCompress;
import com.sl.sso.entity.Company;
import com.sl.sso.service.SSOCommonsService;
import com.sl.zx.entity.Files;
import com.sl.zx.entity.FilesTypeTree;
import com.sl.zx.entity.Permit;
import com.sl.zx.entity.Users;
import com.sl.zx.service.PermitService;
import com.sl.zx.service.ZXCommonsService;
import com.sl.zx.service.ZXService;

@ParentPackage(value = "struts-default")
@Results({
	@Result(name="error",location="/error.jsp")
})
@Action(value = "zxAction1")
@SuppressWarnings({"rawtypes","unchecked"})
public class ZXAction1 extends ActionSupport
{
	private static Logger logger = Logger.getLogger(ZXAction1.class);
	private static final long serialVersionUID = -1837627300119049027L;
	private ZXCommonsService zxCommonsService;
	private SSOCommonsService ssoService;
	private ZXService zxService;
	private PermitService<Permit> permitService;
	private String uid;

	@Autowired
	public void setSsoService(SSOCommonsService ssoService)
	{
		this.ssoService = ssoService;
	}

	@Autowired
	public void setZxCommonsService(ZXCommonsService zxCommonsService)
	{
		this.zxCommonsService = zxCommonsService;
	}
	@Autowired
	public void setZxService(ZXService zxService)
	{
		this.zxService = zxService;
	}
	
	@Autowired
	public void setPermitService(PermitService<Permit> permitService)
	{
		this.permitService = permitService;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	private HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}

	private HttpSession getSession()
	{
		return getRequest().getSession();
	}

	private void textOut(String s)
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=UTF-8");
		try
		{
			resp.getWriter().print(s);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void jsonOut(String s)
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		try
		{
			resp.getWriter().print(s);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private String toJson(Object o)
	{
		Gson gson = new Gson();
		return gson.toJson(o);
	}

	// 转向查看文件页面
	public String goViewFilePage()
	{
		int max = Setting.FILE_PAGE_ROW;
		HttpServletRequest req = getRequest();
		List<Files> list = zxService.findFiles(1, 10);
		List<Company> clist = ssoService.findAllCompany();
		List<Files> flist = zxService.findFilesWithCondition("", "", 1, max, null);
		int pageCount = (zxService.getCountOfFilesWithCondition("", "") + max - 1) / max;
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("pageNow", 1);
		req.setAttribute("clist", clist);
		req.setAttribute("flist", flist);
		req.setAttribute("cids", "");
		req.setAttribute("tids", "");
		req.setAttribute("uid", uid);
//		if ("SL0000".equals(uid))
//		{
			List<FilesTypeTree> toptypes = zxService.getTopTypes();
			
			req.setAttribute("toptypes", toptypes);
//			return "zcFilePage"; // 总裁专页
//		}
		return "viewFilePage";
	}

	// 获取文件类型树
	public String getFileTypeTree()
	{
		List<ZTree> allFilesTypeTree = zxService.getAllFilesTypeTree();
		Gson gson = new Gson();
		String json = gson.toJson(allFilesTypeTree);
		jsonOut(json);
		return null;
	}

	// 查找文件
	public String searchFiles()
	{
		HttpServletRequest req = getRequest();
		Users user = (Users) zxCommonsService.getEntityBySerializableID(Users.class, uid);
		String cids = req.getParameter("cids");
		String tids = req.getParameter("tids");
		String order = req.getParameter("order");
		int max = Setting.FILE_PAGE_ROW;
		HttpServletRequest request = getRequest();
		int pageCount = (zxService.getCountOfFilesWithCondition(cids, tids) + max - 1) / max;
		String pageStr = request.getParameter("pageNow");
		int pageNow = (pageStr != null && pageStr.length() > 0) ? Integer.parseInt(pageStr) : 1;

		List<Files> flist = zxService.findFilesWithCondition(cids, tids, pageNow, max, order);
		List<Company> clist = ssoService.findAllCompany();
		req.setAttribute("clist", clist);
		req.setAttribute("cids", cids);
		req.setAttribute("tids", tids);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("pageNow", pageNow);
		req.setAttribute("flist", flist);
		req.setAttribute("uid", uid);
		return "viewFilePage";
	}

	// 查看文件详情页
	public String showFileDetail()
	{
		HttpServletRequest req = getRequest();
		Integer id = new Integer(req.getParameter("id"));
		Files file = zxService.findFileById(id);

		String sublayerPath = "/zxFileImage/" + file.getCreateTime().substring(0, 7);
		String rootPath = getRequest().getSession().getServletContext().getRealPath("/");
		String realSavePath = rootPath + sublayerPath;
		File dir = new File(realSavePath);
		if (!dir.exists())
		{
			dir.mkdirs();
		}
		String imgname = file.getName() + "." + file.getType();
		dir = new File(realSavePath + "/" + imgname);
		if (!dir.exists())
		{
			ImageCompress.compressImage(Setting.FILE_SRC_IMG_PATH, realSavePath, imgname, "", true);
		}
		req.setAttribute("file", file);
		return "fileDetail";
	}

	// 获取文件压缩后的图片
	public String getFileImage()
	{
		HttpServletRequest req = getRequest();
		String name = req.getParameter("name");
		String date = req.getParameter("date");

		String sublayerPath = "/zxFileImage/" + date.substring(0, 7);
		String rootPath = getRequest().getSession().getServletContext().getRealPath("/");
		String realSavePath = rootPath + sublayerPath;
		File dir = new File(realSavePath);
		if (!dir.exists())
		{
			dir.mkdirs();
		}
		dir = new File(realSavePath + "/" + name);
		if (!dir.exists())
		{
			ImageCompress.compressImage(Setting.FILE_SRC_IMG_PATH, realSavePath, name, "", true);
		}
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("image/jpeg");
		String path = rootPath + "/zxFileImage/" + date.substring(0, 7) + "/" + name;
		try
		{
			File myGifFile = new File(path);
			BufferedImage ima = ImageIO.read(myGifFile);
			ImageIO.write(ima, "jpeg", resp.getOutputStream());
		}
		catch (IOException e)
		{
			logger.error("图片不存在");
		}
		return null;
	}
	
	// 查找所有子级菜单
	public String findSubTypeTree()
	{
		String ids = getRequest().getParameter("ids");
		List<ZTree> list = zxService.getAllFilesTypeTree();
		Map<String, ArrayList<ZTree>> map = new HashMap<String, ArrayList<ZTree>>();
		String str;
		for(ZTree t : list)
		{
			str = t.getpId() + "";
			if(t.getpId() != 0)
			{
				if(map.get(str) == null)
				{
					map.put(str, new ArrayList<ZTree>());
				}
				map.get(str).add(t);
			}
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(map);
		jsonOut(json);
		return null;
	}
	
	// 进入文件概览页面
	public String goFileOverviewPage()
	{
		int max = Setting.FILE_PAGE_ROW;
		HttpServletRequest req = getRequest();
		Users user = (Users) zxCommonsService.getEntityBySerializableID(Users.class, uid);
		List<Company> clist = ssoService.findAllCompany();
		List<Files> flist = zxService.findFilesWithCondition("", "", 1, max, null);
		int pageCount = (zxService.getCountOfFilesWithCondition("", "") + max - 1) / max;
		
		RandomDataClass<Files, FilesTypeTree,FilesTypeTree> data = zxService.getInitData();
		
		Gson gson = new Gson();
		String json = gson.toJson(data.getMap1());
		
		req.setAttribute("data", data);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("pageNow", 1);
		req.setAttribute("clist", clist);
		req.setAttribute("flist", flist);
		req.setAttribute("cids", "");
		req.setAttribute("tids", "");
		req.setAttribute("uid", uid);
		List<FilesTypeTree> toptypes = zxService.getTopTypes();
		req.setAttribute("toptypes", toptypes);
		
		return "goFileOverviewPage";
	}
	
	public String getSecTypeTree()
	{
		Map map = zxService.getSecTypeTree();
		Gson gson = new Gson();
		String json = gson.toJson(map);
		jsonOut(json);
		return null;
	}
	
	public String getSubTypeTreeOrData()
	{
		String tid = getRequest().getParameter("id");
		String cids = getRequest().getParameter("cids");
		int page = Integer.parseInt(getRequest().getParameter("page"));
		Map map = zxService.getSubTypeTree(tid, cids, page);
		Gson gson = new Gson();
		String json = gson.toJson(map);
		jsonOut(json);
		return null;
	}
}












