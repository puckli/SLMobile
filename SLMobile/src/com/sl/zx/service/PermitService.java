package com.sl.zx.service;

import java.util.List;

import com.sl.zx.entity.Permit;

public interface PermitService<T>
{
	public List<Permit> findAll();

	public void saves(Permit permit);
	
	public Permit getPvBySign(String sign);
	
}
