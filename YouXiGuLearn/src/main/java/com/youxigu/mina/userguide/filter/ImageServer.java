package com.youxigu.mina.userguide.filter;

import java.net.InetSocketAddress;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.youxigu.mina.userguide.filter.factory.ImageCodecFactory;

public class ImageServer {

	public static final int PORT = 33789;

	public static void main(String[] args) {

		ImageServerIoHandler handler = new ImageServerIoHandler();
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("protocol", new ProtocolCodecFilter(new ImageCodecFactory(false)));
//		acceptor.setLocalAddress(new InetSocketAddress(PORT));
		acceptor.setHandler(handler);
//		acceptor.bind();
		System.out.println("server is listenig at port " + PORT);

	}
}
//