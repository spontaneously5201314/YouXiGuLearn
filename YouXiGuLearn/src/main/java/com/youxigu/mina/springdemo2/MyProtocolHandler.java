package com.youxigu.mina.springdemo2;

import java.nio.ByteBuffer;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class MyProtocolHandler extends IoHandlerAdapter {

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		if (message instanceof ByteBuffer) {
			ByteBuffer rb = (ByteBuffer) message;
			byte[] moMessage = new byte[rb.remaining()];
			rb.get(moMessage);
			Endpoint endpoint = new MinaEndpoint(session);
			endpoint.receive(moMessage);
		}
		super.messageReceived(session, message);
	}

}
