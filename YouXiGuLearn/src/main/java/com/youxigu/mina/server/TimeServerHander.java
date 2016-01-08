package com.youxigu.mina.server;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
//IoHandlerAdapter 类。这个类遵循了适配器设计模式，简化了需要为满足在一个类中传递实现了 IoHandler 接口的需求而要编写的代码量。
public class TimeServerHander extends IoHandlerAdapter {

	@Override
	//exceptionCaught 应该总是在handler 中定义，来处理一些异常情况，否则异常信息将无法捕捉。
	//exceptionCaught 方法将会对错误和 session 关闭的 stack trace 进行简单打印。对于更多的程序，这将是常规，除非处理器能够从异常情况下进行恢复
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

	@SuppressWarnings("deprecation")
	@Override
	//messageReceived 方法来处理从客户端接收到的数据，这里是将当前时间返回给客户端，当收到quit时，会话将被关闭，也会返回一个当前时间给客户端。
	//根据所使用的协议编解码器，object 这个参数传递的类型有所不同，以及返回的数据时的session.write(Object) 也不同。如果不指定协议的编解码器，
	//你将收到一个类型为IoBuffer 的对象，返回的数据也要求是IoBuffer。
	public void messageReceived(IoSession session, Object message) throws Exception {
		String str = message.toString();
		if (str.trim().equalsIgnoreCase("quit")) {
			session.close();
			return;
		}

		Date date = new Date();
		session.write(date.toString());
		System.out.println("Message written...");
	}

	@Override
	//sessionIdle 方法将定时调用一次会话，保持空闲状态。通过调用acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );来设定时间间隔。
	//一旦 session 保持空闲状态到达 acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 ); 所定义的时间长度，sessionIdle 方法会被调用。
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("IDLE " + session.getIdleCount(status));
	}
}
