package com.sl.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.zx.dao.ZXCommonsDAO;
import com.sl.zx.entity.Permit;
import com.sl.zx.service.PermitService;

@Service(value="permitService")
public class PermitServiceImpl<T> implements PermitService<T>
{
	
	private ZXCommonsDAO<Permit> zxCommonsDAO;
	
	public ZXCommonsDAO<Permit> getZxCommonsDAO()
	{
		return zxCommonsDAO;
	}

	@Autowired
	public void setZxCommonsDAO(ZXCommonsDAO<Permit> zxCommonsDAO)
	{
		this.zxCommonsDAO = zxCommonsDAO;
	}

	@Override
	public List<Permit> findAll()
	{
		return zxCommonsDAO.findByHQL("from Permit");
	}
	
	@Override
	public void saves(Permit permit)
	{
		zxCommonsDAO.saveEntity(permit);
	}
	
	@Override
	public Permit getPvBySign(String sign)
	{
		List<Permit> list = zxCommonsDAO.findByHQL("from Permit where sign='" + sign + "'");
		return list.get(0);
	}

}
