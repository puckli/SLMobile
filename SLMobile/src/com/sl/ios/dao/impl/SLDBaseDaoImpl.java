package com.sl.ios.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sl.ios.dao.SLDBaseDao;

@Repository("SLDbaseDao")
public class SLDBaseDaoImpl<T extends Serializable, PK extends Serializable> implements SLDBaseDao<T, PK>
{
	private SessionFactory iosSessionFactory;

	@Autowired
	@Qualifier("iosSessionFactory")
	public void setIosSessionFactory(SessionFactory sessionFactory)
	{
		this.iosSessionFactory = sessionFactory;
	}

	private final Class<T> entityClass;
	private final String HQL_LIST_ALL;
	private final String HQL_LIST_ALL_DR0;
	private final String HQL_COUNT_ALL;
	private final String HQL_COUNT_ALL_STATE0;
	private final String HQL_LIST_PAGE_ALL;
	private final String HQL_LIST_PAGE_ALL_STATE0;
	private String pkName = null;

	@SuppressWarnings("unchecked")
	public SLDBaseDaoImpl()
	{
		this.entityClass = (Class<T>) (  getClass().getGenericSuperclass()).getClass();
		System.out.println(entityClass.getSimpleName());
		Field[] fields = this.entityClass.getDeclaredFields();
		for (Field f : fields)
		{
			if (f.isAnnotationPresent(Id.class))
			{
				this.pkName = f.getName();
			}
		}

//		Tools.notNull(pkName);
		// TODO @Entity name not null
		HQL_LIST_ALL = "from " + this.entityClass.getSimpleName() + " order by " + pkName + " desc";
		HQL_LIST_ALL_DR0 = "from " + this.entityClass.getSimpleName() + " where dr=0 order by " + pkName + " desc";
		HQL_LIST_PAGE_ALL = "from " + this.entityClass.getSimpleName() + " order by " + pkName + " desc";
		HQL_LIST_PAGE_ALL_STATE0 = "from " + this.entityClass.getSimpleName() + " where state=0 order by " + pkName + " desc";
		HQL_COUNT_ALL = "select count(" + pkName + ") from " + this.entityClass.getSimpleName();
		HQL_COUNT_ALL_STATE0 = "select count(" + pkName + ") from " + this.entityClass.getSimpleName() + " where state=0";
	}

	protected Session getSession()
	{
		return iosSessionFactory.getCurrentSession();
	}

	@Override
	public void save(T o)
	{
		getSession().save(o);
	}

	@Override
	public void saveOrUpdate(T o)
	{
		getSession().saveOrUpdate(o);
	}

	@Override
	public void update(T o)
	{
		getSession().update(o);
	}

	@Override
	public void merge(T o)
	{
		getSession().merge(o);
	}

	@Override
	public void delete(PK id)
	{
		getSession().delete(this.get(id));
	}

	@Override
	public void deleteObject(T o)
	{
		getSession().delete(o);
	}

	@Override
	public T get(PK id)
	{
		return (T) getSession().get(this.entityClass, id);
	}

	@Override
	public T getByHQL(String hql)
	{
		@SuppressWarnings("unchecked")
		List<T> list = getSession().createQuery(hql).list();
		if (list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<T> listPage(String hql, int page, int rows)
	{
		page = page < 1 ? 1 : page;
		return getSession().createQuery(hql).setFirstResult((page - 1) * page).setMaxResults(rows).list();
	}
	
	@Override
	public List<T> listPageState0(int page, int rows)
	{
		page = page < 1 ? 1 : page;
		return getSession().createQuery(HQL_LIST_PAGE_ALL_STATE0).setFirstResult((page - 1) * page).setMaxResults(rows).list();
	}

	@Override
	public List<T> listAll()
	{
		return getSession().createQuery(HQL_LIST_ALL).list();
	}
	
	@Override
	public List<T> listByNative(String sql)
	{
		SQLQuery query = getSession().createSQLQuery(sql);
		List result = query.list();
		return result;
	}
	
	@Override
	public List<T> listAllSTATE0()
	{
		return getSession().createQuery(HQL_LIST_ALL_DR0).list();
	}
	
	@Override
	public Integer countAll()
	{
		return (Integer)getSession().createQuery(HQL_COUNT_ALL).uniqueResult();
	}
	
	@Override
	public Integer countAllState0()
	{
		return (Integer)getSession().createQuery(HQL_COUNT_ALL_STATE0).uniqueResult();
	}

	@Override
	public List<T> listAll(String hql)
	{
		return getSession().createQuery(hql).list();
	}
	
	@Override
	public Integer countAll(String hql)
	{
		return (Integer)getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public int executeHql(String hql)
	{
		return getSession().createQuery(hql).executeUpdate();
	}
	
	
	protected void setParameters(Query query, Object[] paramlist) {
        if (paramlist != null) {
            for (int i = 0; i < paramlist.length; i++) {
                if(paramlist[i] instanceof Date) {
                    //TODO 难道这是bug 使用setParameter不行？？
                    query.setTimestamp(i, (Date)paramlist[i]);
                } else {
                    query.setParameter(i, paramlist[i]);
                }
            }
        }
    }

}
