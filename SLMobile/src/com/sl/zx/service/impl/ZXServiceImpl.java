package com.sl.zx.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.comUtil.RandomDataClass;
import com.sl.comUtil.Setting;
import com.sl.comUtil.ZTree;
import com.sl.zx.dao.ZXCommonsDAO;
import com.sl.zx.entity.Files;
import com.sl.zx.entity.FilesTypeTree;
import com.sl.zx.service.ZXService;

@Service("zxService")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ZXServiceImpl<T> implements ZXService<T>
{

	private ZXCommonsDAO<T> zxCommonsDAO;
	
	@Autowired
	public void setZxCommonsDAO(ZXCommonsDAO<T> zxCommonsDAO)
	{
		this.zxCommonsDAO = zxCommonsDAO;
	}
	
	@Override
	public List<Files> findFiles(int page, int rows)
	{
		return zxCommonsDAO.listByHQL("from Files", page, rows, null);
	}
	
	@Override
	public List<ZTree> getAllFilesTypeTree()
	{
		List<FilesTypeTree> toplist = zxCommonsDAO.findByHQL("from FilesTypeTree f where f.pid is NULL");
		List<ZTree> zlist = new ArrayList<>();
		ZTree tree;
		for(FilesTypeTree t : toplist)
		{
			tree = new ZTree(t.getId(),0,t.getName(),true);
			boolean mark = findChildTree(zlist,t.getId());
			if(mark)
			{
				tree.setParent(true);
			}
			zlist.add(tree);
		}
		
		return zlist;
	}
	
	// 递归查询树子节点
	private boolean findChildTree(List<ZTree> zlist, Integer id)
	{
		List<FilesTypeTree> list = zxCommonsDAO.findByHQL("from FilesTypeTree f where f.pid="+id.toString());
		if(list == null || list.size()==0)
		{
			return false;
		}
		ZTree tree;
		for(FilesTypeTree t : list)
		{
			tree = new ZTree(t.getId(),id,t.getName(),true);
			boolean mark = findChildTree(zlist,t.getId());
			if(mark)
			{
				tree.setParent(true);
			}
			zlist.add(tree);
		}
		return true;
	}
	
	@Override
	public List<Files> findFilesWithCondition(String cids, String tids, int page, int rows, String order)
	{
		StringBuffer hql = new StringBuffer("from Files f where f.dr=0");
		if(!"".equals(cids) && cids != null)
		{
			hql.append(" and f.cid.id in(").append(cids).append(")");
		}
		if(!"".equals(tids))
		{
			hql.append(" and f.fileType.id in(").append(tids).append(")");
		}
		return zxCommonsDAO.listByHQL(hql.toString(), page, rows, null);
	}
	
	@Override
	public int getCountOfFilesWithCondition(String cids, String tids)
	{
		StringBuffer hql = new StringBuffer("select count(f.id) from Files f where f.dr=0");
		if(!"".equals(cids))
		{
			hql.append(" and f.cid.id in(").append(cids).append(")");
		}
		if(!"".equals(tids))
		{
			hql.append(" and f.fileType.id in(").append(tids).append(")");
		}
		List list = zxCommonsDAO.findByHQL(hql.toString());
		return Integer.parseInt(list.get(0).toString());
	}
	
	@Override
	public Files findFileById(Integer id)
	{
		List<Files> list = zxCommonsDAO.findByHQL("from Files f where f.dr=0 and f.id=" + id);
		return list.get(0);
	}
	
	@Override
	public List<FilesTypeTree> getTopTypes()
	{
		List<FilesTypeTree> list = zxCommonsDAO.findByHQL("from FilesTypeTree f where f.pid is null");
		return list;
	}
	
	@Override
	public void findSubTypeTree(String ids)
	{
		String[] idarr = ids.split(",");
		Map<String, List<ZTree>> map = new HashMap<String, List<ZTree>>();
		for(String str : idarr)
		{
			map.put(str, new ArrayList<ZTree>());
		}
		
		List<FilesTypeTree> list = zxCommonsDAO.findByHQL("from FilesTypeTree f where f.pid is not null");
		for(FilesTypeTree f : list)
		{
			String pid = f.getPid();
			if(map.get(pid) != null)
			{
				map.get(pid);
			}
		}
		
		
		List<ZTree> tlist = this.getAllFilesTypeTree();
		for(ZTree t : tlist)
		{
			if(t.getpId() != 0)
			{
				
				
				
				
			}
		}
		
		
	}
	
	
	@Override
	public RandomDataClass<Files, FilesTypeTree, FilesTypeTree> getInitData()
	{
		Session session = this.zxCommonsDAO.getSession();
		RandomDataClass<Files, FilesTypeTree,FilesTypeTree> data = new RandomDataClass<>();
		String topids = "(";
		List<FilesTypeTree> tlist = new ArrayList<FilesTypeTree>();
		List<FilesTypeTree> allist = session.createQuery("from FilesTypeTree").list();
		for(FilesTypeTree f : allist)
		{
			Integer id = f.getId();
			if(f.getPid() == null || "".equals(f.getPid()))
			{
				topids += id.toString() + ",";
				tlist.add(f);
				data.getMap1().put(id.toString(), new ArrayList<FilesTypeTree>());
			}
		}
		for(FilesTypeTree f : allist)
		{
			String id = f.getPid()+"";
			if(topids.indexOf(id) != -1)
			{
				data.getMap1().get(id).add(f);
			}
		}
		for(FilesTypeTree t : tlist)
		{
			Integer id = t.getId();
			List temp = session.createQuery("select count(f.id) from Files f where f.dr=0 and f.fileType.id=" + t.getId()).list();
			data.getMap().put(id, temp.get(0).toString());
			topids += id.toString() + ",";
		}
		topids = topids.substring(0, topids.length()-1) + ")";
		data.setS1(topids);
		List<Files> flist = session.createQuery("from Files f where f.dr=0").setFirstResult(0).setMaxResults(10).list();
		data.setList1(flist);
		data.setList2(tlist);
		return data;
	}
	
	@Override
	public Map getSecTypeTree()
	{
		HashMap map = new HashMap<>();
		List<Integer> list = zxCommonsDAO.findByHQL("select f.id from FilesTypeTree f where f.pid is null");
		for(Integer i : list)
		{
			List<FilesTypeTree> flist = zxCommonsDAO.findByHQL("from FilesTypeTree f where f.pid=" + i);
			map.put(i, flist);
		}
		return map;
	}
	
	@Override
	public Map getSubTypeTree(String tid, String cids, int page)
	{
		HashMap map = new HashMap<>();
		String hql = "from Files f where f.dr=0";
		if(!"".equals(tid))
		{
			// 查询子级types（菜单）
			List<FilesTypeTree> list = zxCommonsDAO.findByHQL("from FilesTypeTree f where f.pid=" + tid);
			map.put("count", list.size());
			map.put("rows", list);
			hql += " and f.fileType.id=" + tid;
			if(list.size()>0)
			{
				String hqls;
				for(FilesTypeTree f : list)
				{
					hqls = "select count(f.id) from Files f where f.dr=0 and f.fileType.id=" + f.getId();
					Integer count = new Integer(zxCommonsDAO.findByHQL(hqls).get(0).toString());
					map.put(f.getName(), count);
				}
			}
		}
		else
		{
			map.put("count", 0);
			map.put("rows", null);
		}
		if(!"".equals(cids))
		{
			hql += " and f.cid.id in" + cids;
		}
		// 查询该类别（filetypes）和公司下的文件
		List<Files> flist = zxCommonsDAO.listByHQL(hql,page,Setting.FILE_PAGE_ROW,null);
		map.put("fileRows", flist);
		map.put("fileCount", flist.size());
		List count = zxCommonsDAO.findByHQL("select count(f.id) " + hql);
		int pageCount = (Integer.parseInt(count.get(0).toString()) + Setting.FILE_PAGE_ROW - 1)/Setting.FILE_PAGE_ROW;
		map.put("fileAllCount", count);
		map.put("pageCount", pageCount);
		return map;
	}
}











