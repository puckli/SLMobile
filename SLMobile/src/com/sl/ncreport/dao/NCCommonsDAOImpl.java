package com.sl.ncreport.dao;

import java.sql.CallableStatement;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("nccommonsDAO")
public class NCCommonsDAOImpl<T> implements NCCommonsDAO<T>
{
	private static final Logger log = Logger.getLogger(NCCommonsDAOImpl.class);

	private SessionFactory ncReportsessionFactory;

	public SessionFactory getSessionFactory()
	{
		return ncReportsessionFactory;
	}

	@Autowired
	public void setNcReportsessionFactory(SessionFactory ncReportsessionFactory)
	{
		this.ncReportsessionFactory = ncReportsessionFactory;
	}

	public Session getSession()
	{
		// 事务必须是开启的(Required)，否则获取不到
		Session session = ncReportsessionFactory.getCurrentSession();
		return session;
	}

	public void saveEntity(T entity)
	{
		getSession().saveOrUpdate(entity);
	}

	public void saveOrUpdateCollection(List<T> entities)
	{
		Session session = getSession();
		// Transaction tx = session.beginTransaction();
		for (T t : entities)
		{
			session.saveOrUpdate(t);
		}
		// tx.commit();
		session.flush();
	}

	@Override
	public void updateEntity(T entity)
	{
		getSession().update(entity);
	}

	public void deleteEntity(T entity)
	{
		getSession().delete(entity);
	}

	public void deleteAll(List<T> entities)
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		for (T t : entities)
		{
			session.delete(t);
		}
		tx.commit();
		session.flush();
	}

	@Override
	public List<T> findAllByClass(Class entity)
	{
		return getSession().createCriteria(entity).list();
	}

	public List findAllByCriteria(Criteria criteria)
	{
		return list(criteria);
	}

	public List findPageByCriteria(Criteria criteria, int first, int max)
	{
		return criteria.setFirstResult(first).setMaxResults(max).list();
	}

	public int getTotalCount(String e)
	{
		Session session = getSession();
		return session.createQuery("from " + e).list().size();
	}

	@Override
	public int getTotalCountByCriteria(Criteria criteria)
	{
		return criteria.list().size();
	}

	@Override
	public int getTotalCountByHQL(String hql)
	{
		Session session = getSession();
		return (Integer) session.createQuery(hql).list().get(0);
	}

	@Override
	public List findByHQL(String hql)
	{
		try
		{
			return getSession().createQuery(hql).list();
		}
		catch (DataAccessException e)
		{
			log.error("查询错误！" + NCCommonsDAOImpl.class.getName() + ".findByHQL " + new Date());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List findByHQL(String hql, int first, int max)
	{
		try
		{
			return getSession().createQuery(hql).setFirstResult(first).setMaxResults(max).list();
		}
		catch (DataAccessException e)
		{
			log.error("查询错误！" + NCCommonsDAOImpl.class.getName() + ".findByHQL " + new Date());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> listByHQL(String hql, int page, int max, Object... args)
	{
		try
		{
			Query query = getSession().createQuery(hql);
			setParameters(query, args);
			if (page > -1 && max > -1)
			{
				query.setMaxResults(max);
				int start = (page - 1) * max;
				start = start < 0 ? 0 : start;
				query.setFirstResult(start);
			}
			return query.list();
		}
		catch (DataAccessException e)
		{
			log.error("查询错误！" + NCCommonsDAOImpl.class.getName() + ".listByHQL " + new Date());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int executeHQL(String hql, Object... args)
	{
		try
		{
			Query query = getSession().createQuery(hql);
			setParameters(query, args);
			return query.executeUpdate();
		}
		catch (DataAccessException e)
		{
			log.error("查询错误！" + NCCommonsDAOImpl.class.getName() + ".executeHQL " + new Date());
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> listByNative(final String nativeSQL)
	{
		SQLQuery query = getSession().createSQLQuery(nativeSQL);
		List<T> result = query.list();
		return result;
	}

	@Override
	public T getEntityBySerializableID(Class<T> cla, int id)
	{
		return (T) getSession().get(cla, id);
	}

	@Override
	public T getEntityBySerializableID(Class<T> cla, String id)
	{
		return (T) getSession().get(cla, id);
	}

	@Override
	public T merge(T entity)
	{
		return (T) getSession().merge(entity);
	}

	public List<T> list(Criteria criteria)
	{
		return criteria.list();
	}

	protected void setParameters(Query query, Object[] paramlist)
	{
		if (paramlist != null)
		{
			for (int i = 0; i < paramlist.length; i++)
			{
				if (paramlist[i] instanceof Date)
				{
					// TODO 难道这是bug 使用setParameter不行？？
					query.setTimestamp(i, (Date) paramlist[i]);
				}
				else
				{
					query.setParameter(i, paramlist[i]);
				}
			}
		}
	}

	@Override
	public List<T> callPROC(String call)
	{
		Session session = getSession();
		SQLQuery query = session.createSQLQuery(call);
		return query.list();
	}

	@Override
	public void callVoidPROC(final String callStr)
	{
		Session session = getSession();
		session.doWork(new Work()
		{
			public void execute(java.sql.Connection conn) throws java.sql.SQLException
			{
				CallableStatement call = conn.prepareCall(callStr);
				call.execute();
			};
		});
	}
}
