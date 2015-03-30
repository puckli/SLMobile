package com.sl.ncreport.service;

import java.util.List;

import com.sl.ncreport.bean.Ncinfo;

public interface NcinfoService {

	List<Ncinfo> findAll();

	Ncinfo findById(String glorgbook1);
}
