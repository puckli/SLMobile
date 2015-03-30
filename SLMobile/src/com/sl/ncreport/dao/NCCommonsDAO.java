package com.sl.ncreport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

@SuppressWarnings("rawtypes")
public interface NCCommonsDAO<T>
{
	public Session getSession();
	public void saveEntity(T entity);

	public void saveOrUpdateCollection(List<T> entities);
	
	void updateEntity(T entity);
	
	public void deleteEntity(T entity);
	
	public void deleteAll(List<T> entities);
	
	public List findAllByCriteria(Criteria criteria);

	public List findPageByCriteria(Criteria criteria, int first, int maxs);
	
	public int getTotalCount(String e);
	
	public int getTotalCountByCriteria(Criteria criteria);

	int getTotalCountByHQL(String hql);

	List findByHQL(String hql);

	T getEntityBySerializableID(Class<T> cla, String id);

	T getEntityBySerializableID(Class<T> cla, int id);

	public T merge(T entity);

	public List<T> findAllByClass(Class entity);

	List<T> listByNative(String nativeSQL);

	List findByHQL(String hql, int first, int max);

	/**
	 * 
	 * @param hql 带参hql
	 * @param page 分页到页码，不分页传-1
	 * @param max	每页数据条数，不分页传-1
	 * @param args 参数，没有则传null
	 * @return
	 */
	List listByHQL(String hql, int page, int max, Object[] args);

	public List<T> callPROC(String call);

	void callVoidPROC(String call);

	int executeHQL(String hql, Object[] args);

}
