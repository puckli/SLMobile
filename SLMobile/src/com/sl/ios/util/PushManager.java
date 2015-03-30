package com.sl.ios.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;
import javapns.exceptions.DuplicateDeviceException;
import javapns.exceptions.NullDeviceTokenException;
import javapns.exceptions.NullIdException;
import javapns.exceptions.UnknownDeviceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;

import com.sl.comUtil.Setting;

public class PushManager extends Thread
{
	private static Log log = LogFactory.getLog(PushManager.class.getName());
	private String token;
	private String messager;
	private int count;
	private String uid;

	public PushManager(String uid)
	{
		this.uid = uid;
	}

	public PushManager(String uid, String messager, int count)
	{
		this.uid = uid;
		this.messager = messager;
		this.count = count;
	}

	public PushManager(String uid, String token, String messager, int count)
	{
		this.uid = uid;
		this.token = token;
		this.messager = messager;
		this.count = count;
	}

	@Override
	public void run()
	{
		sendPush(uid, token, messager, count);
	}

	/************************************************
	 * 测试推送服务器地址：gateway.sandbox.push.apple.com /2195
	 * 产品推送服务器地址：gateway.push.apple.com / 2195
	 * 
	 * 需要javaPNS_2.2.jar包
	 ***************************************************/
	
	/**
	 * 推送方法（单个推送）
	 * @param uid 用户id
	 * @param token 设备token
	 * @param messager 推送的消息内容
	 * @param count app图标上显示的消息数量
	 */
	public static synchronized void sendPush(String uid, String token, String messager, int count)
	{
		PushNotificationManager pushManager = PushNotificationManager.getInstance();
		try
		{
			// 从客户端获取的deviceToken。
			if (token == null || token.length() < 1)
			{
				log.error("token为空 :" + uid);
				return;
			}
			if (messager == null || messager.length() < 1)
			{
				messager = "您有单据需要审批！";
			}
			// 定义消息模式
			PayLoad payLoad = new PayLoad();
			try
			{
				payLoad.addAlert(messager);
				payLoad.addBadge(count);// 消息推送标记数，小红圈中显示的数字。
				payLoad.addSound("default");
			}
			catch (JSONException e1)
			{
				log.error("JSONException:" + uid);
				return;
			}
			// 注册deviceToken

			pushManager.addDevice("iPhone", token);
			
			// 连接APNS
			String host = "gateway.sandbox.push.apple.com";
//			String host = "gateway.push.apple.com";
			int port = 2195;
			String certificatePath = Setting.IOSPUSHKEY;// 前面生成的用于JAVA后台连接APNS服务的*.p12文件位置
			// String certificatePath = "/home/mini/puckKeyCer.p12";//
			String certificatePassword = "slgroup";// p12文件密码。
			pushManager.initializeConnection(host, port, certificatePath, certificatePassword, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
			// 发送推送
			Device client = pushManager.getDevice("iPhone");
			// payLoad.toString() + " ");
			pushManager.sendNotification(client, payLoad);
			log.info("Push Success:" + uid);
			System.out.println("Push Success:" + uid);
		}
		catch (UnknownDeviceException e)
		{
			log.error("UnknownDeviceException :" + uid);
		}
		catch(NullIdException e)
		{
			log.error("NullIdException :" + uid);
		}
		catch(FileNotFoundException e)
		{
			log.error("FileNotFoundException :" + uid);
		}
		catch (DuplicateDeviceException  e)
		{
			log.error("DuplicateDeviceException :" + uid);
		}
		catch (NullDeviceTokenException e)
		{
			log.error("NullDeviceTokenException :" + uid);
		}
		catch (UnrecoverableKeyException e)
		{
			log.error("发送推送失败@UnrecoverableKeyException :" + uid);
		}
		catch (KeyManagementException e)
		{
			log.error("发送推送失败@KeyManagementException :" + uid);
		}
		catch (KeyStoreException e)
		{
			log.error("发送推送失败@KeyStoreException :" + uid);
		}
		catch (NoSuchAlgorithmException e)
		{
			log.error("发送推送失败@NoSuchAlgorithmException :" + uid);
		}
		catch (CertificateException e)
		{
			log.error("发送推送失败@CertificateException :" + uid);
		}
		catch (NoSuchProviderException e)
		{
			log.error("发送推送失败@NoSuchProviderException :" + uid);
		}
		catch (IOException e)
		{
			log.error("发送推送失败@IOException :" + uid);
		}
		catch (Exception e)
		{
			log.error("发送推送失败@Exception :" + uid);
		}
		finally
		{
			try
			{
				// 停止连接APNS
				pushManager.stopConnection();
				// 删除deviceToken
				pushManager.removeDevice("iPhone");
				pushManager = null;
			}
			catch (Exception e)
			{
				log.error("关闭pushManager出错：" + uid);
			}
		}
	}

	public static void main(String[] args)
	{
		String token = null;
//		token = "6bae378c3dc4b26a9d5f669723cda20c0859f31d110a1187506840c7c7f8fc01"; // 总裁
//		token = "deff102f5f76aae853f9e4fe4d52873d54a4db0153b2b477efbf42012fd85b05"; // 
		token = "2dc5ab2884fb0a5d3972beb771fa67613507ac5d3dbf4976b280272b70bc10bd"; 
//		new PushManager("1", token, "提醒您审批单据：SL201407002595和SL201407002598！", 6).start();
		new PushManager("2", token, "您有1条未审批单据！", 1).start();
//		new PushManager("3", token, "您有未审批单据3！", 6).start();
//		new PushManager("4", token, "您有未审批单据4！", 6).start();
		System.out.println("success");
	}
}
