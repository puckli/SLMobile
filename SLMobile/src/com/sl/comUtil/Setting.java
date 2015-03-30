package com.sl.comUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sl.zx.entity.Permit;

public class Setting
{
	private static Logger log = Logger.getLogger(Setting.class);
	/**
	 * 三联单附件原图位置，绝对路径
	 */
	public static String LARGE_IMAGE_PATH;
	public static String SMALL_IMAGE_PATH;
	/**
	 * 图片压缩后的宽
	 */
	public static int IMAGE_WIDTH;
	/**
	 * 图片压缩后的高
	 */
	public static int IMAGE_HEIGHT;
	/**
	 * 压缩后图片的根路径，相对路径
	 */
	public static String SLD_ATTACHMENT_ROOTPATH;
	
	/**
	 * 推送开始时间
	 */
	public static int PUSH_START_TIME;
	/**
	 * 推送结束时间
	 */
	public static int PUSH_END_TIME;
	
	/**
	 * 三联单页显示的行数
	 */
	public static int SLD_PAGE_ROW;
	
	/**
	 * 文件查看页显示的行数
	 */
	public static int FILE_PAGE_ROW;
	
	/**
	 * 文件源大图图片根目录
	 */
	public static String FILE_SRC_IMG_PATH;
	
	public static Map<String, Permit> permitMap = new HashMap<String, Permit>();
	
	public static String IOSPUSHKEY;
	
	public static String DEFAULT_INDEX_PAGE;
	
	public static String ZC_INDEX_PAGE;
	
	public static String zcAccount;
	
	public static String minSID = "18982";

	public Setting()
	{
		log.info("new Setting instance");
	}

	static
	{
		log.info("Setting reload in static block");
		reloadSetting();
		System.out.println("Setting reload");
	}
	
	public static void reloadSetting()
	{
		Properties prop = new Properties();
		String path = Setting.class.getClassLoader().getResource("").getPath();
		InputStream is = null;
		try
		{
			is = new FileInputStream(new File(path + "Setting.properties"));
			prop.load(is);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		LARGE_IMAGE_PATH = prop.getProperty("largeImagePath");
		SMALL_IMAGE_PATH = prop.getProperty("smallImagePath");
		IMAGE_WIDTH = Integer.parseInt(prop.getProperty("imageWidth"));
		IMAGE_HEIGHT = Integer.parseInt(prop.getProperty("imageHeight"));
		SLD_ATTACHMENT_ROOTPATH = prop.getProperty("SLDattachmentRootPath");
		PUSH_START_TIME = Integer.parseInt(prop.getProperty("pushStartTime"));
		PUSH_END_TIME = Integer.parseInt(prop.getProperty("pushEndTime"));
		SLD_PAGE_ROW = Integer.parseInt(prop.getProperty("sldPageRow"));
		FILE_PAGE_ROW = Integer.parseInt(prop.getProperty("filePageRow"));
		FILE_SRC_IMG_PATH = prop.getProperty("fileImagePath");
		IOSPUSHKEY = prop.getProperty("iospushkey");
		DEFAULT_INDEX_PAGE = prop.getProperty("defaultIndexPage");
		ZC_INDEX_PAGE = prop.getProperty("zcIndexPage");
		zcAccount = prop.getProperty("zcAccount");
		minSID = prop.getProperty("minSID");
		prop.clear();
		if(is != null)
		{
			try
			{
				is.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		log.info("Setting reload success");
	}
}
