package com.sl.chatPages.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//@WebServlet(urlPatterns="/websocket/info")
//@WebServlet
@ServerEndpoint("/websocket/info")
public class WebSocketTestInfo extends HttpServlet
{
	@Override
//	@RequestMapping(value = "/websocket/info", method = {RequestMethod.POST})
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.getWriter().print("wo f34f");
		super.doPost(req, resp);
	}

	@Override
//	@RequestMapping(value = "/websocket/info", method = {RequestMethod.GET})
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.getWriter().print("wo 3434");
		
//		super.doGet(req, resp);
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException, InterruptedException
	{

		// Print the client message for testing purposes
		System.out.println("Received: " + message);

		// Send the first message to the client
		session.getBasicRemote().sendText("This is the first server message");

		// Send 3 messages to the client every 5 seconds
		int sentMessages = 0;
		while (sentMessages < 3)
		{
			Thread.sleep(5000);
			session.getBasicRemote().sendText("This is an intermediate server message. Count: " + sentMessages);
			sentMessages++;
		}

		// Send a final message to the client
		session.getBasicRemote().sendText("This is the last server message");
	}

	@OnOpen
	public void onOpen()
	{
		System.out.println("Client connected");
	}

	@OnClose
	public void onClose()
	{
		System.out.println("Connection closed");
	}
}