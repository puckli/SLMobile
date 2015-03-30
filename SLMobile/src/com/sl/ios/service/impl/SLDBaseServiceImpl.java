package com.sl.ios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sl.ios.dao.SLDBaseDao;
import com.sl.ios.service.SLDBaseService;

public abstract class SLDBaseServiceImpl<M extends java.io.Serializable, PK extends java.io.Serializable> implements SLDBaseService<M, PK>
{
	protected SLDBaseDao<M, PK> SLDbaseDao;

	@Autowired
	@Qualifier("SLDbaseDao")
	public void setBaseDao(SLDBaseDao<M, PK> baseDao)
	{
		this.SLDbaseDao = baseDao;
	}

	@Override
	public void save(M o)
	{
		SLDbaseDao.save(o);
	}

	@Override
	public void saveOrUpdate(M o)
	{
		SLDbaseDao.saveOrUpdate(o);
	}

	@Override
	public void update(M o)
	{
		SLDbaseDao.update(o);
	}

	@Override
	public void merge(M o)
	{
		SLDbaseDao.merge(o);
	}

	@Override
	public void delete(PK id)
	{
		SLDbaseDao.delete(id);
	}

	@Override
	public void deleteObject(M o)
	{
		SLDbaseDao.deleteObject(o);
	}

	@Override
	public M get(PK id)
	{
		return SLDbaseDao.get(id);
	}

	@Override
	public M getByHQL(String hql)
	{
		return SLDbaseDao.getByHQL(hql);
	}

	@Override
	public List<M> listPage(String hql, int page, int rows)
	{
		return SLDbaseDao.listPage(hql, page, rows);
	}

	@Override
	public List<M> listPageState0(int page, int rows)
	{
		return SLDbaseDao.listPageState0(page, rows);
	}

	@Override
	public List<M> listAll()
	{
		return SLDbaseDao.listAll();
	}

	@Override
	public List<M> listAllSTATE0()
	{
		return SLDbaseDao.listAllSTATE0();
	}

	@Override
	public Integer countAll()
	{
		return SLDbaseDao.countAll();
	}

	@Override
	public Integer countAllState0()
	{
		return SLDbaseDao.countAllState0();
	}

	@Override
	public List<M> listAll(String hql)
	{
		return SLDbaseDao.listAll(hql);
	}

	@Override
	public Integer countAll(String hql)
	{
		return SLDbaseDao.countAll(hql);
	}

	@Override
	public int executeHql(String hql)
	{
		return SLDbaseDao.executeHql(hql);
	}

}
