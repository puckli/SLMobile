package com.sl.comUtil;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;

import com.sl.zx.entity.Permit;
import com.sl.zx.service.PermitService;

public class InitOnStartServlet extends HttpServlet
{
	private PermitService<Permit> permitService;

	@Autowired
	public void setPermitService(PermitService<Permit> permitService)
	{
		this.permitService = permitService;
	}

	public void run()
	{
		System.out.println(permitService);
		try
		{
			List<Permit> list = permitService.findAll();
		}
		catch (Exception e)
		{
			System.out.println("**************error");
		}
		System.out.println("****************************");
	}
	
	@Override
	public void init() throws ServletException
	{
		System.out.println(permitService);
		try
		{
			List<Permit> list = permitService.findAll();
		}
		catch (Exception e)
		{
			System.out.println("**************error333");
		}
		System.out.println("****************************servlet");
	}
	
}
