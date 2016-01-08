package com.youxigu.mina.userguide.ioservice.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.youxigu.mina.server.ObjectMinaServerHandler;

public class TcpServer {

	public static void main(String[] args) throws IOException {
		// TCP服务器
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		// UDP服务器
		// IoAcceptor acceptor = new NioDatagramAcceptor();
//		acceptor.setHandler(new ObjectMinaServerHandler());
//		acceptor.bind(new InetSocketAddress(18759));
//		System.out.println("Server started...");
//		acceptor.dispose();
//		System.out.println("Server distory...");
//		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//		chain.addLast("logger", new LoggingFilter());
//		acceptor.setFilterChainBuilder(chain);
//		IoSessionConfig sessionConfig = acceptor.getSessionConfig();
//		acceptor.
	}
}
