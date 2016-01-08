package com.youxigu.mina.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.youxigu.mina.pojo.User;

public class ObjectMinaClientHandler extends IoHandlerAdapter {

	// 当一个服务端连结进入时
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("connect server : " + session.getRemoteAddress());
		session.write(new User("mina", 18));
	}

	// 当一个服务端关闭时
	@Override
	public void sessionClosed(IoSession session) {
		System.out.println(session.getRemoteAddress() + " server Disconnect !");
	}

	// 当服务器发送的消息到达时:
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		User u = (User) message;
		System.out.println("这里是客户端(" + session.getLocalAddress() + ")\t,服务器(" + session.getRemoteAddress() + ")发来的消息: "
				+ u.getName() + "\t" + u.getAge());

		// 发送到服务端
		session.write(u);
	}
}
