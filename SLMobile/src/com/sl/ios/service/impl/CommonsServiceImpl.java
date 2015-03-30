package com.sl.ios.service.impl;

import java.util.List;

import org.hibernate.Criteria;

import com.sl.comUtil.dao.CommonsDAO;
import com.sl.ios.service.CommonsService;

public class CommonsServiceImpl<T> implements CommonsService<T>
{

	private CommonsDAO<T> commonsDAO;
	public CommonsDAO<T> getCommonsDAO()
	{
		return commonsDAO;
	}
	public void setCommonsDAO(CommonsDAO<T> commonsDAO)
	{
		this.commonsDAO = commonsDAO;
	}
	
	public void saveEntity(T entity) {
		commonsDAO.saveEntity(entity);
	}
	
	public void saveOrUpdateCollection(List<T> entities)
	{
		commonsDAO.saveOrUpdateCollection(entities);
	}
	
	@Override
	public void updateEntity(T entity)
	{
		commonsDAO.updateEntity(entity);
	}
	
	public void deleteEntity(T entity)
	{
		commonsDAO.deleteEntity(entity);
	}
	
	public void deleteAll(List<T> entities)
	{
		commonsDAO.deleteAll(entities);
	}
	
	public List<T> findAll(Class entity)
	{
		return commonsDAO.findAllByClass(entity);
	}
	
	public List<T> findPageByCriteria(Criteria criteria, int first, int maxs)
	{
		return commonsDAO.findPageByCriteria(criteria, first, maxs);
	}
	public int getTotalCount(String e)
	{
		
		return commonsDAO.getTotalCount(e);
	}
	
	@Override
	public int getTotalCountByCriteria(Criteria criteria)
	{
		return commonsDAO.getTotalCountByCriteria(criteria);
	}
	
	@Override
	public int getTotalCountByHQL(String hql)
	{
		return commonsDAO.getTotalCountByHQL(hql);
	}
	
	@Override
	public List findByHQL(String hql)
	{
		return commonsDAO.findByHQL(hql);
	}
	
	@Override
	public T getEntityBySerializableID(Class<T> cla,int id)
	{
		return commonsDAO.getEntityBySerializableID(cla, id);
	}
	
	@Override
	public T getEntityBySerializableID(Class<T> cla,String id)
	{
		return commonsDAO.getEntityBySerializableID(cla, id);
	}
	
	public T merge(T entity){
		return commonsDAO.merge(entity);
	}
	
}
