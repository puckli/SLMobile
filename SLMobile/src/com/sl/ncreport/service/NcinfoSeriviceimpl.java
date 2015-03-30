package com.sl.ncreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.ncreport.bean.Ncinfo;
import com.sl.ncreport.dao.NCCommonsDAO;

@Service("ncinfoService")
public class NcinfoSeriviceimpl implements NcinfoService {
	private NCCommonsDAO<Ncinfo> nccommonsDAO;

	public NCCommonsDAO<Ncinfo> getCommonsDAO() {
		return nccommonsDAO;
	}
	@Autowired
	public void setNccommonsDAO(NCCommonsDAO<Ncinfo> nccommonsDAO) {
		this.nccommonsDAO = nccommonsDAO;
	}
	@Override
	public List<Ncinfo> findAll() {
		return nccommonsDAO.findByHQL("from Ncinfo");
	}
	
	@Override
	public Ncinfo findById(String glorgbook1) {
		// "from Ncinfo where id=" + glorgbook1;
		return nccommonsDAO.getEntityBySerializableID(Ncinfo.class, new Integer(glorgbook1));
	}
}
