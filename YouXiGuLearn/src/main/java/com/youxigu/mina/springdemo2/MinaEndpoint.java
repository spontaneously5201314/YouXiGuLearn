package com.youxigu.mina.springdemo2;

import java.nio.ByteBuffer;

import org.apache.commons.lang.ArrayUtils;
import org.apache.mina.core.session.IoSession;

public class MinaEndpoint implements Endpoint {

	private IoSession session;

	public MinaEndpoint(IoSession session) {
		this.session = session;
	}

	public void send(byte[] data) {
		if (session.isConnected() && ArrayUtils.isEmpty(data)) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(data.length);
			byteBuffer.put(data);
			byteBuffer.flip();
			session.write(byteBuffer);
		}
	}

	public void receive(byte[] data) {
		//Service的实现操作
	}
}