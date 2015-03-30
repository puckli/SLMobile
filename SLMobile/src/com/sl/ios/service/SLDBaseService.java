package com.sl.ios.service;

import java.util.List;

public interface SLDBaseService<T extends java.io.Serializable, PK extends java.io.Serializable>
{
	void save(T o);

	void saveOrUpdate(T o);

	void update(T o);

	void merge(T o);

	void delete(PK id);

	void deleteObject(T o);

	T get(PK id);
	
	T getByHQL(String hql);
	
	List<T> listPage(String hql,int page,int rows);
	
	List<T> listPageState0(int page,int rows);
	
	List<T> listAll();

	List<T> listAllSTATE0();
	
	Integer countAll();
	
	Integer countAllState0();
	
	List<T> listAll(String hql);
	
	Integer countAll(String hql);
	
	int executeHql(String hql);
}
