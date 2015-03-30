package com.sl.ncreport.service;

import java.util.List;

import com.sl.ncreport.bean.Ncbb;

public interface NcService {
	public void save (Ncbb ncbb);

	public Ncbb findByTime(String subject, String year, String month, String day);
	public List<Ncbb> findall(String year1,String month1,String day1,String company,String System);
	
	

}
