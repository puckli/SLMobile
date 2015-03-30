package com.sl.zx.service;

import java.util.List;
import java.util.Map;

import com.sl.comUtil.RandomDataClass;
import com.sl.comUtil.ZTree;
import com.sl.zx.entity.Files;
import com.sl.zx.entity.FilesTypeTree;

public interface ZXService<T>
{

	List<Files> findFiles(int page, int rows);

	List<ZTree> getAllFilesTypeTree();

	int getCountOfFilesWithCondition(String cids, String tids);

	List<Files> findFilesWithCondition(String cids, String tids, int page, int rows, String order);

	Files findFileById(Integer id);

	List<FilesTypeTree> getTopTypes();

	void findSubTypeTree(String ids);

	RandomDataClass<Files, FilesTypeTree, FilesTypeTree> getInitData();

	Map getSecTypeTree();

	/**
	 * map包含文件数据 和 子级类型数据
	 * @param tid 文件类型id
	 * @param cids 公司id
	 * @param page 页面
	 * @return
	 */
	Map getSubTypeTree(String tid, String cids, int page);
	
}
