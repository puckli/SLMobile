package com.sl.ios.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sl.comUtil.Setting;

public class PushPolling
{
	private static Log log = LogFactory.getLog(PushPolling.class.getName());
	public static int a = 0;
	public static Timer timer = new Timer();
	public static boolean mark = false;
	public static Connection conn = null;

	public static void main(String[] args) throws SQLException
	{
		startPushPolling();
	}

	public static int startPushPolling() throws SQLException
	{
		timer = new Timer();
		if (mark)
		{
			return 0;
		}
		else
		{
			
			if (conn == null || conn.isClosed())
			{
				conn = getConnction();
			}
			// 查需要推送的uid;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select uid,token from PushToken where dr=0");
			Map<String,String> UIDS = new HashMap<String,String>();
			String uid;
			String token;
			while(rs.next())
			{
				uid = rs.getString("uid");
				token = rs.getString("token");
				UIDS.put(uid, token);
				System.out.println("Push List: " + uid + " : " + token);
				log.info("Push List: " + uid + " : " + token);
			}
			
			
			timer.schedule(new PushTimerTask(conn, UIDS), 1000, 300000);
//			timer.schedule(new PushTimerTask(conn, UIDS), 1000, 10000);
			mark = true;
			System.out.println("pushPolling task start !" + UIDS.size());
			log.info("PushPolling Task start !" + UIDS.size());
			return 1;
		}
	}

	public static int cancelPushPolling()
	{
		timer.cancel();
		timer.purge();
		mark = false;
		a = 0;
		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("PushPolling Task end !");
		log.info("PushPolling Task end !");
		return 1;
	}

	public static Connection getConnction()
	{
		String url = "";
		String username = "";
		String password ="";
		try
		{
			String path = PushPolling.class.getClassLoader().getResource("").getPath();
//			System.out.println(path);
			InputStream is = new FileInputStream(new File(path + "jdbc.properties"));
			Properties prop = new Properties();
			prop.load(is);
			url = prop.getProperty("jdbc.url");
			username = prop.getProperty("jdbc.username");
			password = prop.getProperty("jdbc.password");
		}
		catch (FileNotFoundException e1)
		{
			log.error("启动轮询推送失败，找不到jdbc.properties");
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			log.error("启动轮询推送失败 @IOException");
			e1.printStackTrace();
		}
		
		try
		{
			return DriverManager.getConnection(url, username, password);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}


class PushTimerTask extends TimerTask
{
	private Connection conn = null;
	int count = 0;
	Map<String,String> uids = null;

	public PushTimerTask()
	{
	}

	public PushTimerTask(Connection conn, Map<String,String> uids)
	{
		this.uids = uids;
		this.conn = conn;
	}

	public void run()
	{
		// 控制轮询推送的时间
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
//		int minite = cal.get(Calendar.MINUTE);
		if(hour < Setting.PUSH_START_TIME || hour >= Setting.PUSH_END_TIME)return;
		
		Set<String> set = uids.keySet();
		for(Iterator<String> iter = set.iterator(); iter.hasNext();)
		{
			String uid = iter.next();
			String token = uids.get(uid);
			push(uid, token);
		}
		
	}
	
	public void push(String uid, String token)
	{
		String sql = "select count(*) as count from sanlianceshi s left join sldexamine e on s.sldexamine=e.seid " +
				"where (e.examineName='" + uid + "') and s.readed<>1 and s.zh is null and s.sid>18982 and s.dr=0";
		String messager = "您有未审批单据！";
		try
		{
			PreparedStatement st = conn.prepareStatement(sql);
//			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery();
			rs.next();
			count = rs.getInt("count");
			if(count>0){
				PushManager push = new PushManager(uid, token, messager, count);
				push.start();
			}
			st.close();
			count = 0;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
