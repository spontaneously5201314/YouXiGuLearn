package com.youxigu.mina.server;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MyServer {

	private static Logger logger = Logger.getLogger(MyServer.class);

	private static int PORT = 8900;

	public static void main(String[] args) {
		// 创建非阻塞的server端的socket
		IoAcceptor acceptor = null;
		try {
			acceptor = new NioSocketAcceptor();
			// 设置日志过滤器
			acceptor.getFilterChain().addLast("logger", new LoggingFilter());
			acceptor.getFilterChain().addLast( // 添加消息过滤器
					"codec",
					// Mina自带的根据文本换行符编解码的TextLineCodec过滤器 看到\r\n就认为一个完整的消息结束了
					new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"),
							LineDelimiter.WINDOWS.getValue(), LineDelimiter.WINDOWS.getValue())));
			// 设置读取数据的缓冲区的大小
			acceptor.getSessionConfig().setReadBufferSize(2048);
			// 读取通道10s内无操作进入空闲状态
			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
			// 绑定逻辑处理器
			acceptor.setHandler(new ServerMessageHandler());
			// 绑定端口
			acceptor.bind(new InetSocketAddress(PORT));
			logger.info("服务器启动成功.. 端口号为:" + PORT);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
