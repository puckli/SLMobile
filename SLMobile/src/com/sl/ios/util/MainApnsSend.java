package com.sl.ios.util;

import java.util.ArrayList;
import java.util.List;

import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MainApnsSend
{
	private static Log log = LogFactory.getLog(PushManager.class.getName());

	public static void main(String[] args) throws Exception
	{
		push();
	}
	
	public static void push() throws Exception
	{
		try
		{
			String deviceToken = "f3ffb3879fd21f8a62e36524b1e89068454f7fda98e1056cbefa5e3a664c5cb9";// iphone手机获取的token
			List<String> tokens = new ArrayList<>();
			tokens.add(deviceToken);
			// message是一个json的字符串{“aps”:{“alert”:”iphone推送测试”}}
//			String message = "{'aps':{'alert':'iphone推送测试','badge':1}}";
//			PushNotificationPayload payLoad = PushNotificationPayload.fromJSON(message);
			PushNotificationPayload payLoad = new PushNotificationPayload();
			payLoad.addBadge(1); // 图标小红圈的数值
			payLoad.addSound("default"); // 铃音 默认
			payLoad.addAlert("iphone推送测试");
			PushNotificationManager pushManager = new PushNotificationManager();
			// Connect to APNs
			/**
			 * 测试的服务器地址：gateway.sandbox.push.apple.com /端口2195
			 * 产品推送服务器地址：gateway.push.apple.com / 2195
			 */
			String path = "D:/JavaWebApplication/puckKeyCer.p12";// 导出的证书
			String password = "slgroup";// 此处注意导出的证书密码不能为空因为空密码会报错
			pushManager.initializeConnection(new AppleNotificationServerBasicImpl(path, password, false));// true：表示产品推送服务器
																											// false：表示测试的服务器
			List<PushedNotification> notifications = new ArrayList<PushedNotification>();
			// 发送push消息 sendCount 是个boolean类型的值用来区分单发还是群发 true：单发 false：群发
			boolean sendCount = false;
			if (sendCount)
			{
				log.info("--------------------------apple 推送 单-------" + tokens.get(0));
				Device device = new BasicDevice();
				device.setToken(tokens.get(0));
				PushedNotification notification = pushManager.sendNotification(device, payLoad, true);
				notifications.add(notification);
			}
			else
			{
				log.info("--------------------------apple 推送 群-------" + tokens.size());
				List<Device> device = new ArrayList<Device>();
				for (String token : tokens)
				{
					device.add(new BasicDevice(token));
				}
				notifications = pushManager.sendNotifications(payLoad, device);
			}
			List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications);
			List<PushedNotification> successfulNotifications = PushedNotification.findSuccessfulNotifications(notifications);
			int failed = failedNotifications.size();
			int successful = successfulNotifications.size();
			if (successful > 0 && failed == 0)
			{
				log.info("-----All notifications pushed 成功 (" + successfulNotifications.size() + "):");
				System.out.println(successfulNotifications.get(0).getDevice().getToken());
			}
			else if (successful == 0 && failed > 0)
			{
				 log.info("-----All notifications 失败 (" +
				 failedNotifications.size() + "):");
//				 failedNotifications.get(0).getDevice().getToken();
			}
			else if (successful == 0 && failed == 0)
			{
				System.out.println("No notifications could be sent, probably because of a critical error");
			}
			else
			{
				log.info("------Some notifications 失败 (" + failedNotifications.size() + "):");
				log.info("------Others 成功 (" + successfulNotifications.size() + "):");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}