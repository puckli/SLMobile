package com.sl.sso.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.sso.dao.SSOCommonsDAO;
import com.sl.sso.entity.Company;
import com.sl.sso.service.SSOCommonsService;

@Service("ssoService")
public class SSOCommonsServiceImpl<T> implements SSOCommonsService<T>
{

	private SSOCommonsDAO<T> ssoCommonsDAO;

	public SSOCommonsDAO<T> getSsoCommonsDAO()
	{
		return ssoCommonsDAO;
	}
	@Autowired
	public void setSsoCommonsDAO(SSOCommonsDAO<T> ssoCommonsDAO)
	{
		this.ssoCommonsDAO = ssoCommonsDAO;
	}

	public void saveEntity(T entity)
	{
		ssoCommonsDAO.saveEntity(entity);
	}

	public void saveOrUpdateCollection(List<T> entities)
	{
		ssoCommonsDAO.saveOrUpdateCollection(entities);
	}

	@Override
	public void updateEntity(T entity)
	{
		ssoCommonsDAO.updateEntity(entity);
	}

	public void deleteEntity(T entity)
	{
		ssoCommonsDAO.deleteEntity(entity);
	}

	public void deleteAll(List<T> entities)
	{
		ssoCommonsDAO.deleteAll(entities);
	}

	public List<T> findAll(Class entity)
	{
		return ssoCommonsDAO.findAllByClass(entity);
	}

	public List<T> findPageByCriteria(Criteria criteria, int first, int maxs)
	{
		return ssoCommonsDAO.findPageByCriteria(criteria, first, maxs);
	}

	public int getTotalCount(String e)
	{

		return ssoCommonsDAO.getTotalCount(e);
	}

	@Override
	public int getTotalCountByCriteria(Criteria criteria)
	{
		return ssoCommonsDAO.getTotalCountByCriteria(criteria);
	}

	@Override
	public int getTotalCountByHQL(String hql)
	{
		return ssoCommonsDAO.getTotalCountByHQL(hql);
	}

	@Override
	public List findByHQL(String hql)
	{
		return ssoCommonsDAO.findByHQL(hql);
	}

	@Override
	public T getEntityBySerializableID(Class<T> cla, int id)
	{
		return ssoCommonsDAO.getEntityBySerializableID(cla, id);
	}

	@Override
	public T getEntityBySerializableID(Class<T> cla, String id)
	{
		return ssoCommonsDAO.getEntityBySerializableID(cla, id);
	}

	public T merge(T entity)
	{
		return ssoCommonsDAO.merge(entity);
	}
	
	@Override
	public List<Company> findAllCompany()
	{
		return ssoCommonsDAO.findByHQL("from Company where dr=0");
	}

}
