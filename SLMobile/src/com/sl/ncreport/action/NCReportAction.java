package com.sl.ncreport.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.ncreport.bean.Ncbb;
import com.sl.ncreport.bean.Ncinfo;
import com.sl.ncreport.service.NcService;
import com.sl.ncreport.service.NcinfoService;

@ParentPackage(value = "mydefault")
@Namespace("/ncreport")
@Action(value = "ncReportAction")
public class NCReportAction
{
	private static final char[] BigDecimal = null;
	private NcService ncService;
	private NcinfoService ncinfoService;
	private String str1;
	private Integer id;
	private String System;

	@Autowired
	public void setNcService(NcService ncService)
	{
		this.ncService = ncService;
	}

	@Autowired
	public void setNcinfoService(NcinfoService ncinfoService)
	{
		this.ncinfoService = ncinfoService;
	}

	private HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}

	private void textOut(String s)
	{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=UTF-8");
		try
		{
			resp.getWriter().print(s);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Action(value = "/search", results = { @Result(name = "nc", location = "/ncReport/ncsearch0.jsp") })
	public String search()
	{
		List<Ncinfo> list = ncinfoService.findAll();
		getRequest().setAttribute("list", list);
		return "nc";
	}

	@Action(value = "/searched", results = { @Result(name = "nc", location = "/ncReport/ncsearch0.jsp") })
	public String searched()
	{
		List<Ncinfo> list = ncinfoService.findAll();

		HttpServletRequest req = getRequest();
		getRequest().setAttribute("list", list);
		String system = "Ferp";
		String year1 = req.getParameter("year");
		String month1 = req.getParameter("month");
		String day1 = req.getParameter("day");
		String company = req.getParameter("company");
		HttpSession session = getRequest().getSession();
		session.setAttribute("year1", year1);
		session.setAttribute("month1", month1);
		session.setAttribute("day1", day1);

		List<Ncbb> list1 = ncService.findall(year1, month1, day1, company, system);

		if (list1 != null)
		{
			for (Ncbb nc : list1)
			{

				req.setAttribute(nc.getSubject(), nc);

			}
		}

		return "nc";
	}
}
