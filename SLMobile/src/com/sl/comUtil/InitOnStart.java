package com.sl.comUtil;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.sl.ios.util.PushPolling;

public class InitOnStart
{
	private Logger log = Logger.getLogger(InitOnStart.class);
//	private PermitService<Permit> permitService;

//	@Autowired
//	public void setPermitService(PermitService<Permit> permitService)
//	{
//		this.permitService = permitService;
//	}

	public void run()
	{
//		System.out.println(permitService);
//		try
//		{
//			List<Permit> list = permitService.findAll();
//			for(Permit p : list)
//			{
//				Setting.permitMap.put(p.getSign(), p);
//			}
//			System.out.println("*****************initSuccess");
//			log.info("*****************initSuccess");
//		}
//		catch (Exception e)
//		{
//			log.error("*****************initError");
//			System.out.println("*****************initError");
//		}
		try
		{
			// 初始化开启推送
			// PushPolling.startPushPolling();
		}
		catch (Exception e)
		{
			log.error("*****************initError on start PushPolling");
			System.out.println("*****************initError on start PushPolling");
		}
	}
	
}
