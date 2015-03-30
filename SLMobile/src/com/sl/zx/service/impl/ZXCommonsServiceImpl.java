package com.sl.zx.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.zx.dao.ZXCommonsDAO;
import com.sl.zx.service.ZXCommonsService;

@Service("zxCommonsService")
public class ZXCommonsServiceImpl<T> implements ZXCommonsService<T>
{

	private ZXCommonsDAO<T> zxCommonsDAO;
	
	@Autowired
	public void setZxCommonsDAO(ZXCommonsDAO<T> zxCommonsDAO)
	{
		this.zxCommonsDAO = zxCommonsDAO;
	}

	public void saveEntity(T entity) {
		zxCommonsDAO.saveEntity(entity);
	}
	
	public void saveOrUpdateCollection(List<T> entities)
	{
		zxCommonsDAO.saveOrUpdateCollection(entities);
	}
	
	@Override
	public void updateEntity(T entity)
	{
		zxCommonsDAO.updateEntity(entity);
	}
	
	public void deleteEntity(T entity)
	{
		zxCommonsDAO.deleteEntity(entity);
	}
	
	public void deleteAll(List<T> entities)
	{
		zxCommonsDAO.deleteAll(entities);
	}
	
	public List<T> findAll(Class entity)
	{
		return zxCommonsDAO.findAllByClass(entity);
	}
	
	public List<T> findPageByCriteria(Criteria criteria, int first, int maxs)
	{
		return zxCommonsDAO.findPageByCriteria(criteria, first, maxs);
	}
	public int getTotalCount(String e)
	{
		
		return zxCommonsDAO.getTotalCount(e);
	}
	
	@Override
	public int getTotalCountByCriteria(Criteria criteria)
	{
		return zxCommonsDAO.getTotalCountByCriteria(criteria);
	}
	
	@Override
	public int getTotalCountByHQL(String hql)
	{
		return zxCommonsDAO.getTotalCountByHQL(hql);
	}
	
	@Override
	public List findByHQL(String hql)
	{
		return zxCommonsDAO.findByHQL(hql);
	}
	
	@Override
	public T getEntityBySerializableID(Class<T> cla,int id)
	{
		return zxCommonsDAO.getEntityBySerializableID(cla, id);
	}
	
	@Override
	public T getEntityBySerializableID(Class<T> cla,String id)
	{
		return zxCommonsDAO.getEntityBySerializableID(cla, id);
	}
	
	public T merge(T entity){
		return zxCommonsDAO.merge(entity);
	}
	
}
