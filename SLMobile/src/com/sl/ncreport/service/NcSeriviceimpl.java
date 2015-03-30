package com.sl.ncreport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.ncreport.bean.Ncbb;
import com.sl.ncreport.dao.NCCommonsDAO;



@Service("ncService")
public class NcSeriviceimpl implements NcService {
	private NCCommonsDAO<Ncbb> nccommonsDAO;

	@Autowired
	public void setCommonsDAO(NCCommonsDAO<Ncbb> nccommonsDAO) {
		this.nccommonsDAO = nccommonsDAO;
	}

	@Override
	public void save(Ncbb ncbb) {
		String  sql = "from Ncbb where datatime='"+ncbb.getDatatime()+"' and system='" + ncbb.getSystem()
				+ "' and company= '"+ncbb.getCompany()+"' and subject = '"+ncbb.getSubject()+"'";
		List<Ncbb > n  = nccommonsDAO.findByHQL(sql);
		if(null!=n && n.size()>0){
			ncbb.setId(n.get(0).getId());
			
		}
		
		nccommonsDAO.merge(ncbb);
		
	}
	
	@Override
	public Ncbb findByTime(String subject, String year, String month, String day) {
		List<Ncbb> list = nccommonsDAO.findByHQL("from Ncbb where subject='"+subject+"' and datatime='" + year+"-" + month + "-" + day + "'");
		return list != null ? list.get(0) : null;
	}
	
	
	public List<Ncbb> findall(String year1,String month1,String day1,String company,String System){
		List<Ncbb> list = nccommonsDAO.findByHQL("from Ncbb where datatime='"+year1+"-"+month1+"-"+day1+"' and  system = '"+System+"' and company='"+company+"'");
		return list;
	}
	
}



















