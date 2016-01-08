package com.youxigu.mina.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MyClient {

	private static Logger logger = Logger.getLogger(MyClient.class);

	private static String HOST = "127.0.0.1";

	private static int PORT = 8900;

	public static void main(String[] args) {
		// 创建一个非组设的客户端客户端
		IoConnector connector = new NioSocketConnector();
		// 设置链接超时时间
		connector.setConnectTimeoutMillis(30000);
		// 添加过滤器
		connector.getFilterChain().addLast( // 添加消息过滤器
				"codec",
				// Mina自带的根据文本换行符编解码的TextLineCodec过滤器 看到\r\n就认为一个完整的消息结束了
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"),
						LineDelimiter.WINDOWS.getValue(), LineDelimiter.WINDOWS.getValue())));
		// 添加业务逻辑处理器类
		connector.setHandler(new ClientMessageHandler());
		IoSession session = null;
		try {
			ConnectFuture future = connector.connect(new InetSocketAddress(HOST, PORT));
			future.awaitUninterruptibly(); // 等待连接创建完成
			session = future.getSession();
			session.write("mina");
		} catch (Exception e) {
			logger.info("客户端链接异常...");
		}

		session.getCloseFuture().awaitUninterruptibly();
		logger.info("Mina要关闭了");
		connector.dispose();
	}
}
