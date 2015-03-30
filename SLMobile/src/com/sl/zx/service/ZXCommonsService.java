package com.sl.zx.service;

import java.util.List;

import org.hibernate.Criteria;

public interface ZXCommonsService<T>
{
	public void saveEntity(T entity);

	public void saveOrUpdateCollection(List<T> entities);
	
	void updateEntity(T entity);
	
	public void deleteEntity(T entity);
	
	public void deleteAll(List<T> entities);
	
	/*
	 * 查询实体包含dr字段，查询全部dr=0的数据；
	 */
	public List<T> findAll(Class entity);

	public List findPageByCriteria(Criteria criteria, int first, int maxs);
	/**
	 * 
	 * @param e 字符串形式传入实体的类名
	 * @return
	 */
	public int getTotalCount(String e);

	T getEntityBySerializableID(Class<T> cla, String id);

	T getEntityBySerializableID(Class<T> cla, int id);

	List findByHQL(String hql);

	int getTotalCountByHQL(String hql);

	int getTotalCountByCriteria(Criteria criteria);
	
	public T merge(T entity);

}
