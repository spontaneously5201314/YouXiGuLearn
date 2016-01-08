package com.youxigu.mina.userguide.filter;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.example.imagine.step1.client.ImageListener;
import org.apache.mina.example.imagine.step1.codec.ImageCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketConnector;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.youxigu.mina.userguide.filter.response.ImageResponse;

public class ImageClient extends IoHandlerAdapter {

	public static final int CONNECT_TIMEOUT = 3000;

	private String host;
	private int port;
	private SocketConnector connector;
	private IoSession session;
	private ImageListener imageListener;

	public ImageClient(String host, int port, ImageListener imageListener) {
		this.host = host;
		this.port = port;
		this.imageListener = imageListener;
		connector = new NioSocketConnector();
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ImageCodecFactory(true)));
		connector.setHandler(this);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		ImageResponse response = (ImageResponse)message;
		imageListener.onImages(response.getImage1(), response.getImage2());
	}

}
