package com.youxigu.mina.server;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ServerMessageHandler extends IoHandlerAdapter {

	public static Logger logger = Logger.getLogger(ServerMessageHandler.class);

	public void sessionCreated(IoSession session) throws Exception {
		logger.info("服务端与客户端创建连接");
	}

	public void sessionOpened(IoSession session) throws Exception {
		logger.info("服务器与客户端连接打开...");
	}

	public void messageReceived(IoSession session, java.lang.Object message) throws Exception {
		String msg = message.toString();
		logger.info("服务端接收的数据为:" + msg);
		if ("bye".equals(msg)) {// 服务器断开的条件
			session.close(true);
		}
		Date date = new Date();
		session.write(date);
	}

	public void messageSent(IoSession session, Object message) throws Exception {
		logger.info("服务端发送消息成功...");
	}

	public void sessionIdle(IoSession session, IdleStatus status) throws java.lang.Exception {
		logger.info("服务端进入空闲状态...");
	}

	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		logger.info("服务端发送异常..." + cause);
	}

	public void sessionClosed(IoSession session) throws Exception {
		logger.info("关闭连接...");
	}

}
